package org.mates.osb.resources;

import org.mates.osb.ISource;
import org.mates.osb.export.IExportProvider;
import org.mates.osb.path.IPath;

public interface IResource {

	/**
	 * identified this type of resource
	 * 
	 * @return
	 */
	public ResourceType getType();

	/**
	 * Name of the resource. Local name of the file.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Construct path for current resource.
	 * @return
	 */
	public IPath getPath();

	/**
	 * returns resource for current resource if avaiable.
	 * @return null if not source for resource
	 */
	public ISource getSource();
	
	/**
	 * ExportProvider for this resource. ExportProvider prepares resource to export. 
	 * Copy to dest directory, change extension, envelope source file. 
	 * @return
	 */
	public IExportProvider getExportProvider();
}
