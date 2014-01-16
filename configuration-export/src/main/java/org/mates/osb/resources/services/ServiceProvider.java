package org.mates.osb.resources.services;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.mates.osb.export.IExportDirectory;
import org.mates.osb.export.IExportProvider;
import org.mates.osb.resources.ExportProvider;
import org.mates.osb.resources.IResource;
import org.mates.osb.utils.FileUtils;

public abstract class ServiceProvider extends ExportProvider implements IExportProvider {

	public ServiceProvider(IResource resource) {
		super(resource);
	}

	protected abstract String getFilename();

	protected File getTargetFile(IExportDirectory dir) {
		String pathWithoutExtension = getResource().getPath().buildPath("/");
		String stringFilePath = pathWithoutExtension + "." + getResourceType().name();
		return new File(dir.getExportDir(), stringFilePath);
	}

	protected void createdDirForFile(File file) {
		file.getParentFile().mkdirs();
	}

	@Override
	public void exportTo(IExportDirectory dir) throws IOException {
		File destFile = getTargetFile(dir);
		createdDirForFile(destFile);

		writeSpecificData(destFile);
	}

	protected void writeSpecificData(File destFile) throws IOException {
		FileOutputStream fous = null;
		InputStream source = null;
		try {
			fous = new FileOutputStream(destFile);
			source = getResource().getSource().getInputStream();

			IOUtils.copy(source, fous);
		} finally {
			FileUtils.closeQuietly(fous);
			FileUtils.closeQuietly(source);
		}
	}
}
