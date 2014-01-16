package org.mates.osb.export;

import java.io.IOException;

import org.mates.osb.resources.ReferenceType;

/**
 * An object that implements this interface, provide all resource export.
 * 
 * @author mates
 */
public interface IExportProvider {

	public ReferenceType getResourceType();

	public IExportItem getExportItem();

	/**
	 * Method should export resource to target directory. Copy content and make
	 * some other customizations.
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public void exportTo(IExportDirectory dir) throws IOException;
}
