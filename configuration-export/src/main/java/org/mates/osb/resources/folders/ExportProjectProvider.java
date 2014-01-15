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

import org.mates.osb.resources.IResource;

public class ExportProjectProvider extends ExportFolderProvider {

	protected static final String EXPORT_FILE_NAME = "_projectdata.LocationData";

	public ExportProjectProvider(IResource dir) {
		super(dir);
	}

	@Override
	protected String getFilename() {
		return EXPORT_FILE_NAME;
	}

}
