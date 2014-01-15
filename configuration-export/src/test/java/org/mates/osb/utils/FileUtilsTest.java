package org.mates.osb.utils;

import java.io.File;

import org.junit.Test;

public class FileUtilsTest {

	@Test
	public void testGetExtension() {
		org.junit.Assert.assertEquals("", FileUtils.getExtension(new File("name")));
		org.junit.Assert.assertEquals("", FileUtils.getExtension(new File("")));
		org.junit.Assert.assertEquals("xml", FileUtils.getExtension(new File("name.xml")));
	}

}
