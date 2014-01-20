package org.mates.osb;

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
import org.mates.osb.resources.ResourceType;

public class ResourceBuilderTest {

	@Test
	public void test() {
		ResourceBuilder resourceBuilder = new ResourceBuilder();
		resourceBuilder.buildTree(new File("d:\\svn\\osb\\trunk\\configuration\\OBS"));
	}

	@Test
	public void testGetResource() {
		ResourceBuilder resourceBuilder = new ResourceBuilder();
		Assert.assertEquals(ResourceType.PROXY, resourceBuilder.getResource(new File("test.proxy"), null).getType());
		Assert.assertEquals(ResourceType.BIZ, resourceBuilder.getResource(new File("test.biz"), null).getType());
		Assert.assertEquals(ResourceType.ACCOUNT, resourceBuilder.getResource(new File("test.sa"), null).getType());
		Assert.assertEquals(ResourceType.PROVIDER, resourceBuilder.getResource(new File("test.skp"), null).getType());
		Assert.assertEquals(ResourceType.ALERT, resourceBuilder.getResource(new File("test.alert"), null).getType());
	}

}
