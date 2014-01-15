package org.mates.osb.resources;

import java.io.File;

import org.junit.Test;

public class ResourceBuilderTest {

	@Test
	public void test() {
		ResourceBuilder resourceBuilder = new ResourceBuilder();
		resourceBuilder.buildTree(new File("d:\\svn\\osb\\trunk\\configuration\\OBS"));
	}

}
