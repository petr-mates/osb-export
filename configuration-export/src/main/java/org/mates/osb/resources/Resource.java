package org.mates.osb.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Resource implements IResource {

	private List<IResource> resourceList = new ArrayList<IResource>();

	public void addResource(IResource resource) {
		resourceList.add(resource);
	}

	public List<IResource> getResources() {		
		return Collections.unmodifiableList(resourceList);
	}
}
