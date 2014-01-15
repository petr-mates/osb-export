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

import org.mates.osb.path.IPath;
import org.mates.osb.path.Path;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.ResourceType;

public class Project extends Folder implements IResource {

	public Project(File file) {
		super(file, null);
	}

	public ResourceType getType() {
		return ResourceType.PROJECT;
	}

	public IPath getPath() {
		return new Path(getName());
	}

}
