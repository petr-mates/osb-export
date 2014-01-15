package org.mates.osb.resources.folders;

import java.io.File;

import org.mates.osb.ISource;
import org.mates.osb.export.IExportProvider;
import org.mates.osb.path.IPath;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.Resource;
import org.mates.osb.resources.ResourceType;

public class Folder extends Resource implements IResource {

	private File dirFile;

	private IResource parent;

	public Folder(File file, IResource parent) {
		this.parent = parent;
		dirFile = file;
	}

	/**
	 * Returns {@link ResourceType#FOLDER}
	 */
	public ResourceType getType() {
		return ResourceType.FOLDER;
	}

	/**
	 * returns name of the directory
	 */
	public String getName() {
		return dirFile.getName();
	}

	public IExportProvider getExportProvider() {
		return new ExportFolderProvider(this);
	}

	public IPath getPath() {
		IPath path = parent.getPath();
		path.addChild(getName());
		return path;
	}

	public ISource getSource() {
		return null;
	}
}
