package org.mates.osb.resources.folders;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mates.osb.export.IExportDirectory;
import org.mates.osb.resources.IResource;

public class ExportFolderProviderTest {

	private static final String TEST_DIRECTORY = "./target/test-folder1/";

	private File expected = new File(TEST_DIRECTORY + "project/folder");

	@Before
	@After
	public void clean() {
		new File(expected, ExportFolderProvider.EXPORT_FILE_NAME).delete();
		expected.delete();
		expected.getParentFile().delete();
		expected.getParentFile().getParentFile().delete();
	}

	@Test
	public void testExportTo() throws IOException {
		IResource project = ProjectTest.getProject(new File("project"));
		IResource folder = FolderTest.getFolder(new File("folder"), project);

		ExportFolderProvider exportDirectoryProvider = new ExportFolderProvider((Folder) folder);
		IExportDirectory iExportDirectory = new IExportDirectory() {

			public File getExportDir() {
				return new File(TEST_DIRECTORY);
			}
		};
		exportDirectoryProvider.exportTo(iExportDirectory);
		Assert.assertTrue(expected.isDirectory() && expected.exists());
		File folderFile = new File(expected, ExportFolderProvider.EXPORT_FILE_NAME);
		Assert.assertTrue(folderFile.exists() && folderFile.isFile());

	}

}
