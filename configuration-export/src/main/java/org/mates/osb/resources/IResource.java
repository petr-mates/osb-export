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

import org.mates.osb.ISource;
import org.mates.osb.export.IExportProvider;
import org.mates.osb.path.IPath;

public interface IResource {

	/**
	 * identified this type of resource
	 * 
	 * @return
	 */
	public ResourceType getType();

	/**
	 * Name of the resource. Local name of the file.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Construct path for current resource.
	 * @return
	 */
	public IPath getPath();

	/**
	 * returns resource for current resource if avaiable.
	 * @return null if not source for resource
	 */
	public ISource getSource();
	
	/**
	 * ExportProvider for this resource. ExportProvider prepares resource to export. 
	 * Copy to dest directory, change extension, envelope source file. 
	 * @return
	 */
	public IExportProvider getExportProvider();
}
