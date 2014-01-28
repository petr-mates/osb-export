package org.mates.osb.reference;

import org.mates.osb.resources.ResourceType;

public class Reference implements IReference {

	private ResourceType type;

	private String originalValue;

	private String path;

	public Reference(ResourceType type, String originalValue, String path) {
		this.type = type;
		this.originalValue = originalValue;
		this.path = path;
	}

	@Override
	public ResourceType getType() {
		return type;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public String getOriginalValue() {
		return originalValue;
	}

}
