package org.mates.osb.resources.folders;

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
