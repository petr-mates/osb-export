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

import org.mates.osb.export.IExportProvider;
import org.mates.osb.path.IPath;
import org.mates.osb.path.ISource;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.Resource;
import org.mates.osb.resources.ResourceType;

public class Folder extends Resource implements IResource {

	private File dirFile;

	private IResource parent;

	public Folder(File file, IResource parent) {
		this.parent = parent;
		dirFile = file;
	}

	/**
	 * Returns {@link ResourceType#FOLDER}
	 */
	public ResourceType getType() {
		return ResourceType.FOLDER;
	}

	/**
	 * returns name of the directory
	 */
	public String getName() {
		return dirFile.getName();
	}

	public IExportProvider getExportProvider() {
		return new ExportFolderProvider(this);
	}

	public IPath getPath() {
		IPath path = parent.getPath();
		path.addChild(getName());
		return path;
	}

	public ISource getSource() {
		return null;
	}
}
