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
import org.mates.osb.resources.IReference;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.ReferenceType;
import org.mates.osb.resources.ResourceType;

public class SimpleService extends Service {

	private ResourceType resourceType;

	public SimpleService(File file, IResource parent, ResourceType resourceType) {
		super(file, parent);
		this.resourceType = resourceType;
	}

	public ResourceType getType() {
		return resourceType;
	}

	public IExportProvider getExportProvider() {
		return new SimpleServiceProvider(this, getReferenceType());
	}

	public List<IReference> getReferences() {
		// TODO implements
		return null;
	}

	protected ReferenceType getReferenceType() {
		ReferenceType ref = null;
		switch (resourceType) {
		case BIZ:
			ref = ReferenceType.BusinessService;
			break;
		case PROXY:
			ref = ReferenceType.ProxyService;
			break;
		case ALERT:
			ref = ReferenceType.AlertDestination;
			break;
		case PROVIDER:
			ref = ReferenceType.ServiceProvider;
			break;
		case ACCOUNT:
			ref = ReferenceType.ServiceAccount;
			break;
		default:
			break;
		}
		return ref;
	}
}
