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
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mates.osb.export.IExportDirectory;
import org.mates.osb.resources.IResource;

public class ExportProjectProviderTest {

	private static final String TEST_DIRECTORY = "./target/test-folder2/";

	private File expected = new File(TEST_DIRECTORY + "project");

	@Before
	@After
	public void clean() {
		new File(expected, ExportProjectProvider.EXPORT_FILE_NAME).delete();
		expected.delete();
		expected.getParentFile().delete();
	}

	@Test
	public void testExportTo() throws IOException {
		IResource project = ProjectTest.getProject(new File("project"));

		ExportProjectProvider exportDirectoryProvider = new ExportProjectProvider(project);
		IExportDirectory iExportDirectory = new IExportDirectory() {

			public File getExportDir() {
				return new File(TEST_DIRECTORY);
			}
		};
		exportDirectoryProvider.exportTo(iExportDirectory);
		Assert.assertTrue(expected.isDirectory() && expected.exists());
		File folderFile = new File(expected, ExportProjectProvider.EXPORT_FILE_NAME);
		Assert.assertTrue(folderFile.exists() && folderFile.isFile());
	}
}
