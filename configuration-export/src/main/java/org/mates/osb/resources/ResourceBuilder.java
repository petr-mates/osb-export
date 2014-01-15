package org.mates.osb.resources;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.mates.osb.resources.folders.Folder;
import org.mates.osb.resources.folders.Project;
import org.mates.osb.resources.services.Service;

public class ResourceBuilder {

	private Set<String> ignoredDirs = new HashSet<String>();

	{
		ignoredDirs.add(".settings");
		ignoredDirs.add("test");
		ignoredDirs.add("docs");
	}

	public Project buildTree(File directory) {
		Project project = new Project(directory);
		build(project, directory);
		return project;
	}

	protected void build(Folder parent, File directory) {
		for (File file : directory.listFiles()) {
			if (ignoredDirs.contains(file.getName())) {
				continue;
			}
			if (file.isDirectory()) {
				Folder newFolder = buildFolder(file, parent);
				build(newFolder, file);
				if (newFolder.getResources().size() > 0) {
					parent.addResource(newFolder);
				}
			} else {
				IResource resource = getResource(file, parent);
				if (resource != null) {
					parent.addResource(resource);
				}
			}
		}
	}

	protected Folder buildFolder(File file, Resource parent) {
		return new Folder(file, parent);
	}

	public IResource getResource(File file, Folder parent) {
		return new Service(file, parent);
	}
}
