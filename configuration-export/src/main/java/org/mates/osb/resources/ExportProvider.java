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

import org.mates.osb.export.IExportProvider;

public abstract class ExportProvider implements IExportProvider {

	private IResource resource;

	public ExportProvider(IResource resource) {
		this.resource = resource;
	}

	protected IResource getResource() {
		return resource;
	}

	@Override
	public ExportItem getExportItem() {
		ExportItem exportItem = new ExportItem();
		ReferenceType resourceType = getReferenceType();
		exportItem.setDataClass(resourceType.getClazz());
		exportItem.setRepresentationVersion(Integer.toString(resourceType.getVersion()));
		exportItem.setIsEncrypted("false");
		exportItem.setJarEntry(getJarEntry());
		exportItem.setTypeId(resourceType.toString());
		exportItem.setInstanceId(getResource().getPath().buildPath("/"));
		return exportItem;
	}

	/**
	 * gets Jar Entry for this resource. default implementation is
	 * <code>resource.path.buildPath('/') '.' resourceType<code>.
	 * @return
	 */
	protected String getJarEntry() {
		return getResource().getPath().buildPath("/") + "." + getReferenceType().toString();
	}
}
