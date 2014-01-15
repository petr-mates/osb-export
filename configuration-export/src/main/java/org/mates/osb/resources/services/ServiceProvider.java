package org.mates.osb.resources.services;

import org.mates.osb.export.IExportDirectory;
import org.mates.osb.export.IExportItem;
import org.mates.osb.export.IExportProvider;
import org.mates.osb.resources.IResource;

public abstract class ServiceProvider implements IExportProvider {

	private IResource resource;

	public ServiceProvider(IResource resource) {
		this.resource = resource;
	}

	public IExportItem getExportItem() {
		return null;
	}

	public void exportTo(IExportDirectory dir) {
		
	}

}
