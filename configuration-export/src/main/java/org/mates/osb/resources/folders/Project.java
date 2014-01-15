package org.mates.osb.resources.folders;

import java.io.File;

import org.mates.osb.path.IPath;
import org.mates.osb.path.Path;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.ResourceType;

public class Project extends Folder implements IResource {

	public Project(File file) {
		super(file, null);
	}

	public ResourceType getType() {
		return ResourceType.PROJECT;
	}

	public IPath getPath() {
		return new Path(getName());
	}

}
