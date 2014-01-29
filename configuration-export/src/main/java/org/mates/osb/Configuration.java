package org.mates.osb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mates.osb.export.IExportDirectory;
import org.mates.osb.export.IExportItem;
import org.mates.osb.export.IExportProvider;
import org.mates.osb.resources.IFolderResource;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.folders.Project;
import org.mates.osb.utils.FileUtils;

public class Configuration implements IConfiguration {

	private File sourceDir;
	private List<String> sourceProjects = new ArrayList<String>();
	private List<IExportItem> exportItems = new ArrayList<IExportItem>();

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
		IExportProvider exportProvider = resource.getExportProvider();
		exportProvider.exportTo(output);
		exportItems.add(exportProvider.getExportItem());
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

		File file = new File(output.getExportDir(), "ExportInfo");
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			new ExportInfoBuilder().build(fileOutputStream, exportItems);
		} catch (IOException e) {
			FileUtils.closeQuietly(fileOutputStream);
			throw e;
		}
	}
}
