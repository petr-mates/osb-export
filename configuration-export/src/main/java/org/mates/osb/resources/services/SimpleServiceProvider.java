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


import org.mates.osb.resources.IResource;
import org.mates.osb.resources.ReferenceType;

public class SimpleServiceProvider extends ServiceProvider {

	private ReferenceType referenceType;

	public SimpleServiceProvider(IResource resource, ReferenceType referenceType) {
		super(resource);
		this.referenceType = referenceType;
	}

	public ReferenceType getReferenceType() {
		return referenceType;
	}

	@Override
	protected String getFilename() {
		return getResource().getName() + "." + getReferenceType().name();
	}

}
