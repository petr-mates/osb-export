package org.mates.osb.resources;

import org.mates.osb.export.IExportProvider;

public abstract class ExportProvider implements IExportProvider {

	private IResource resource;

	public ExportProvider(IResource resource) {
		this.resource = resource;
	}

	protected IResource getResource() {
		return resource;
	}

}
