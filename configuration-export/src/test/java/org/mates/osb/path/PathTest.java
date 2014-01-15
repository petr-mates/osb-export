package org.mates.osb.path;

import org.junit.Assert;
import org.junit.Test;

public class PathTest {

	@Test
	public void testPath() {
		Path path = new Path("root");
		Assert.assertArrayEquals(new String[] { "root" }, path.toArray());
	}

	@Test
	public void testBuildPath() {
		Path path = new Path("root");
		Assert.assertEquals("root", path.buildPath(""));
		path.addChild("folder");
		Assert.assertEquals("root.folder", path.buildPath("."));
	}

	@Test
	public void testToArray() {
		Path path = new Path("root");
		path.addChild("folder");
		Assert.assertArrayEquals(new String[] { "root", "folder" }, path.toArray());
	}

}
