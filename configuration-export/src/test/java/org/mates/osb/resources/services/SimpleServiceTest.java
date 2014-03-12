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

import org.junit.Assert;
import org.junit.Test;
import org.mates.osb.resources.ReferenceType;
import org.mates.osb.resources.ResourceType;
import org.mates.osb.resources.folders.Project;

public class SimpleServiceTest {

	private SimpleService getFakeProxy() {
		return new SimpleService(new File(""), new Project(new File("")), ResourceType.PROXY);
	}

	@Test
	public void testGetType() {
		SimpleService proxyService = getFakeProxy();
		Assert.assertEquals(ResourceType.PROXY, proxyService.getType());
	}

	@Test
	public void testExportProvider() {
		SimpleService proxyService = getFakeProxy();
		Assert.assertNotNull(proxyService.getExportProvider());
	}
	
	@Test
	public void testGetResourceType() {
		Assert.assertEquals(ResourceType.BIZ, new SimpleService(null, null, ResourceType.BIZ).getType());
		Assert.assertEquals(ResourceType.PROXY, new SimpleService(null, null, ResourceType.PROXY).getType());
	}

	@Test
	public void testGetReferenceType() {
		SimpleService service = new SimpleService(null, null, ResourceType.BIZ);
		Assert.assertEquals(ReferenceType.BusinessService, service.getReferenceType());

		service = new SimpleService(null, null, ResourceType.PROXY);
		Assert.assertEquals(ReferenceType.ProxyService, service.getReferenceType());

		Assert.assertEquals(ReferenceType.ServiceProvider,
				new SimpleService(null, null, ResourceType.PROVIDER).getReferenceType());
		Assert.assertEquals(ReferenceType.AlertDestination,
				new SimpleService(null, null, ResourceType.ALERT).getReferenceType());
		Assert.assertEquals(ReferenceType.ServiceAccount,
				new SimpleService(null, null, ResourceType.ACCOUNT).getReferenceType());

		service = new SimpleService(null, null, ResourceType.FOLDER);
		Assert.assertNull(service.getReferenceType());
	}
}
