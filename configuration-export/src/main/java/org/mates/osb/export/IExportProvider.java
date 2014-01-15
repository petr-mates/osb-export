package org.mates.osb.export;

import java.io.IOException;

import org.mates.osb.resources.ReferenceType;

public interface IExportProvider {

	public ReferenceType getResourceType();
	
	public IExportItem getExportItem();

	public void exportTo(IExportDirectory dir) throws IOException;
}
