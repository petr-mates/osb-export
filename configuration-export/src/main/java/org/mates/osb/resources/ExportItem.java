package org.mates.osb.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mates.osb.export.IExportItem;

public class ExportItem implements IExportItem {

	private String instanceId;

	private String typeId;

	private String representationVersion;

	private String dataClass;

	private String isEncrypted;

	private String jarEntry;

	private List<String> extRefs = new ArrayList<String>();

	private Map<String, String> property = new HashMap<String, String>();

	@Override
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Override
	public String getTypeId() {
		return typeId;
	}

	public void setRepresentationVersion(String value) {
		representationVersion = value;
	}

	@Override
	public String getRepresentationVersion() {
		return representationVersion;
	}

	public void setDataClass(String value) {
		dataClass = value;
	}

	@Override
	public String getDataClass() {
		return dataClass;
	}

	public void setIsEncrypted(String value) {
		isEncrypted = value;
	}

	@Override
	public String getIsEncrypted() {
		return isEncrypted;
	}

	public void setJarEntry(String value) {
		jarEntry = value;
	}

	@Override
	public String getJarEntry() {
		return jarEntry;
	}

	@Override
	public void addExtRefs(String value) {
		extRefs.add(value);
	}

	@Override
	public List<String> getExtRefs() {
		return Collections.unmodifiableList(extRefs);
	}

	@Override
	public void putProperty(String key, String value) {
		property.put(key, value);
	}

	@Override
	public Map<String, String> getProperties() {
		return Collections.unmodifiableMap(property);
	}

}
