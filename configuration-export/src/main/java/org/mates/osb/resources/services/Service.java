package org.mates.osb.resources.services;

import java.io.File;
import java.util.List;

import org.mates.osb.ISource;
import org.mates.osb.Source;
import org.mates.osb.export.IExportProvider;
import org.mates.osb.path.IPath;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.Reference;
import org.mates.osb.resources.ResourceType;
import org.mates.osb.utils.FileUtils;

public class Service implements IResource {

	private IResource parent;
	private File file;

	public Service(File file, IResource parent) {
		this.parent = parent;
		this.file = file;
	}

	public ResourceType getType() {
		return null;
	}

	public String getName() {
		return FileUtils.getBaseName(file.getName());
	}

	public IPath getPath() {
		IPath path = parent.getPath();
		path.addChild(getName());
		return path;
	}

	public ISource getSource() {
		return new Source(this.file);
	}

	public IExportProvider getExportProvider() {
		return null;
	}

	public List<Reference> getReferences() {
		// TODO implements
		return null;
	}
}
