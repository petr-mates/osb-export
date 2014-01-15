package org.mates.osb.resources.services;

import org.mates.osb.resources.IResource;
import org.mates.osb.resources.ReferenceType;

public class ProxyServiceProvider extends ServiceProvider {

	public ProxyServiceProvider(IResource resource) {
		super(resource);
	}

	public ReferenceType getResourceType() {
		return ReferenceType.ProxyService;
	}

}
