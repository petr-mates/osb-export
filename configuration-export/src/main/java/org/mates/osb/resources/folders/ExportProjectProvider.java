package org.mates.osb.resources.folders;

import org.mates.osb.resources.IResource;

public class ExportProjectProvider extends ExportFolderProvider {

	protected static final String EXPORT_FILE_NAME = "_projectdata.LocationData";

	public ExportProjectProvider(IResource dir) {
		super(dir);
	}

	@Override
	protected String getFilename() {
		return EXPORT_FILE_NAME;
	}

}
