package org.mates.osb.resources;

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
import java.util.HashSet;
import java.util.Set;

import org.mates.osb.resources.folders.Folder;
import org.mates.osb.resources.folders.Project;
import org.mates.osb.resources.services.Service;

public class ResourceBuilder {

	private Set<String> ignoredDirs = new HashSet<String>();

	{
		ignoredDirs.add(".settings");
		ignoredDirs.add("test");
		ignoredDirs.add("docs");
	}

	public Project buildTree(File directory) {
		Project project = new Project(directory);
		build(project, directory);
		return project;
	}

	protected void build(Folder parent, File directory) {
		for (File file : directory.listFiles()) {
			if (ignoredDirs.contains(file.getName())) {
				continue;
			}
			if (file.isDirectory()) {
				Folder newFolder = buildFolder(file, parent);
				build(newFolder, file);
				if (newFolder.getResources().size() > 0) {
					parent.addResource(newFolder);
				}
			} else {
				IResource resource = getResource(file, parent);
				if (resource != null) {
					parent.addResource(resource);
				}
			}
		}
	}

	protected Folder buildFolder(File file, Resource parent) {
		return new Folder(file, parent);
	}

	public IResource getResource(File file, Folder parent) {
		return new Service(file, parent);
	}
}
