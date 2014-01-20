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
import java.util.List;

import org.mates.osb.export.IExportProvider;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.IReference;
import org.mates.osb.resources.ResourceType;

public class ProxyService extends Service {

	public ProxyService(File file, IResource parent) {
		super(file, parent);
	}

	public ResourceType getType() {
		return ResourceType.PROXY;
	}

	public IExportProvider getExportProvider() {
		return new ProxyServiceProvider(this);
	}

	public List<IReference> getReferences() {
		// TODO implements
		return null;
	}
}
