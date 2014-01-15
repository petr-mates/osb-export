package org.mates.osb.path;

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
