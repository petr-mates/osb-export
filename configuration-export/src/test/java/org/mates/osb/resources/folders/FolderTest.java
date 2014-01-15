package org.mates.osb.resources.folders;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.ResourceType;
import org.mates.osb.resources.folders.Folder;
import org.mates.osb.resources.folders.Project;

public class FolderTest {

	public static IResource getFolder(File file, IResource parent) {
		return new Folder(file, parent);
	}

	private Project parent = new Project(new File("parent"));

	@Test
	public void testGetType() {
		Assert.assertEquals(ResourceType.FOLDER, new Folder(null, parent).getType());
	}

	@Test
	public void testGetName() {
		Assert.assertEquals("testName", new Folder(new File("testName"), parent).getName());
	}

	@Test
	public void testGetReferences() {
		Assert.assertArrayEquals(new IResource[0], new Folder(new File(""), parent).getResources().toArray());
	}

	@Test
	public void testAddResource() {
		Folder directory = new Folder(new File(""), parent);
		directory.addResource(directory);
		Assert.assertArrayEquals(new IResource[]{directory}, directory.getResources().toArray());
	}

	@Test
	public void testGetPath() {
		Folder directory = new Folder(new File("child"), parent);
		Assert.assertEquals("parent.child", directory.getPath().buildPath("."));
	}

}
