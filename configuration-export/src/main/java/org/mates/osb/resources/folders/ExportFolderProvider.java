package org.mates.osb.resources.folders;

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
import org.mates.osb.export.IExportItem;
import org.mates.osb.export.IExportProvider;
import org.mates.osb.path.IPath;
import org.mates.osb.resources.ExportProvider;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.ReferenceType;

public class ExportFolderProvider extends ExportProvider implements IExportProvider {

	protected static final String EXPORT_FILE_NAME = "_folderdata.LocationData";

	public ExportFolderProvider(IResource dir) {
		super(dir);
	}

	public IExportItem getExportItem() {
		return null;
	}

	protected String getFilename() {
		return EXPORT_FILE_NAME;
	}

	public ReferenceType getResourceType() {
		return ReferenceType.LocationData;
	}

	protected File getDestDirectory(IExportDirectory dir) {
		String path = getPath().buildPath("/");
		File export = dir.getExportDir();
		return new File(export, path);
	}

	public void exportTo(IExportDirectory dir) throws IOException {
		File destDir = getDestDirectory(dir);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
		writeFolderSpecificData(destDir);
	}

	protected void writeFolderSpecificData(File destFolder) throws IOException {
		InputStream resourceAsStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(new File(destFolder, getFilename()));
			resourceAsStream = ExportProjectProvider.class.getResourceAsStream("LocationData.xml");
			IOUtils.copy(resourceAsStream, fileOutputStream);
		} finally {
			IOUtils.closeQuietly(resourceAsStream);
			IOUtils.closeQuietly(fileOutputStream);
		}
	}

	protected IPath getPath() {
		return getResource().getPath();
	}

}
