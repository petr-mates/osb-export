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

import org.junit.Assert;
import org.junit.Test;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.ResourceType;
import org.mates.osb.resources.folders.Project;

public class ProjectTest {

	public static IResource getProject(File file) {
		return new Project(file);
	}

	@Test
	public void testGetType() {
		Assert.assertEquals(ResourceType.PROJECT, new Project(null).getType());
	}

	@Test
	public void testGetPath() {
		Assert.assertEquals(ResourceType.PROJECT, new Project(null).getType());
	}

	@Test
	public void testAddResource() {
		Project directory = new Project(new File(""));
		directory.addResource(directory);
		Assert.assertArrayEquals(new IResource[]{directory}, directory.getResources().toArray());
	}

	@Test
	public void testGetName() {
		Assert.assertEquals("testName", new Project(new File("testName")).getName());
	}

	@Test
	public void testGetReferences() {
		Assert.assertArrayEquals(new IResource[0], new Project(new File("")).getResources().toArray());
	}

}
