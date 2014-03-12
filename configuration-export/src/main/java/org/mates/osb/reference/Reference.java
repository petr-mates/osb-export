package org.mates.osb.reference;

import org.mates.osb.resources.ReferenceType;

public class Reference implements IReference {

	private ReferenceType type;

	private String originalValue;

	private String path;

	public Reference(ReferenceType type, String originalValue, String path) {
		this.type = type;
		this.originalValue = originalValue;
		this.path = path;
	}

	@Override
	public ReferenceType getType() {
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
