package org.mates.osb.resources.folders;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.mates.osb.export.IExportDirectory;
import org.mates.osb.export.IExportItem;
import org.mates.osb.export.IExportProvider;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.ReferenceType;

public class ExportFolderProvider implements IExportProvider {

	protected static final String EXPORT_FILE_NAME = "_folderdata.LocationData";

	private IResource folder;

	public ExportFolderProvider(IResource dir) {
		folder = dir;
	}

	public IExportItem getExportItem() {
		return null;
	}

	protected File getDestDirectory(IExportDirectory dir) {
		String path = folder.getPath().buildPath("/");
		File export = dir.getExportDir();
		return new File(export, path);
	}

	public void exportTo(IExportDirectory dir) throws IOException {
		File destDir = getDestDirectory(dir);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
		writeFolderSpecificData(destDir);
	}
	
	protected String getFilename() {
		return EXPORT_FILE_NAME;
	}

	public ReferenceType getResourceType() {		
		return ReferenceType.LocationData;
	}
	
		
	protected void writeFolderSpecificData(File destFolder) throws IOException {
		InputStream resourceAsStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(new File(destFolder, getFilename()));
			resourceAsStream = ExportProjectProvider.class.getResourceAsStream("LocationData.xml");
			IOUtils.copy(resourceAsStream, fileOutputStream);		
		} finally {
			IOUtils.closeQuietly(resourceAsStream);
			IOUtils.closeQuietly(fileOutputStream);
		}
	}

}
