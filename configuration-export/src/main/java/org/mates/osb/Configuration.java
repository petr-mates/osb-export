package org.mates.osb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mates.osb.export.IExportDirectory;
import org.mates.osb.resources.IFolderResource;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.folders.Project;

public class Configuration implements IConfiguration {

	private File sourceDir;
	private List<String> sourceProjects = new ArrayList<String>();

	@Override
	public void setSourceDirectory(File directory) {
		sourceDir = directory;
	}

	@Override
	public void addProject(String project) {
		sourceProjects.add(project);
	}

	protected List<Project> getProjects() {
		ResourceBuilder rb = new ResourceBuilder();

		List<Project> projects = new ArrayList<Project>();

		for (String project : sourceProjects) {
			File file = new File(sourceDir, project);
			System.out.println(file.getAbsolutePath());
			projects.add(rb.buildTree(file));
		}
		return projects;
	}

	protected void export(IResource resource, IExportDirectory output) throws IOException {
		resource.getExportProvider().exportTo(output);
		if (resource instanceof IFolderResource) {
			List<IResource> resources = ((IFolderResource) resource).getResources();
			for (IResource iResource : resources) {
				export(iResource, output);
			}
		}
	}

	@Override
	public void exportToDirectory(IExportDirectory output) throws IOException {
		List<Project> projects = getProjects();
		for (Project project : projects) {
			export(project, output);
		}
	}
}
