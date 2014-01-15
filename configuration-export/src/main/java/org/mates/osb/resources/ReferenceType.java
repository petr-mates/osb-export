package org.mates.osb.resources;

public enum ReferenceType {

	ServiceAccount("com.bea.wli.sb.svcacct.StaticServiceAccountConfig", 25), //
	AlertDestination("com.bea.wli.monitoring.alert.impl.AlertDestinationImpl", 30), //
	BusinessService("com.bea.wli.sb.services.impl.ServiceDefinitionImpl", 3000), //
	ProxyService("com.bea.wli.sb.services.impl.ServiceDefinitionImpl", 3000), //
	WSDL("com.bea.wli.sb.resources.config.impl.WsdlEntryDocumentImpl", 0), //
	XMLSchema("com.bea.wli.sb.resources.config.impl.SchemaEntryDocumentImpl", 0), //
	XML("com.bea.wli.sb.resources.config.impl.XmlEntryDocumentImpl", 0), //
	FLOW("com.bea.alsb.flow.resources.flow.FlowResourceData", 0), //
	Xquery("com.bea.wli.sb.resources.config.impl.XqueryEntryDocumentImpl", 0), //
	ServiceProvider("com.bea.wli.sb.svcprov.ProxyServiceProviderConfig", 25), //
	JCA("com.bea.wli.sb.resources.config.impl.JcaEntryDocumentImpl", 0), //
	LocationData("com.bea.wli.config.project.impl.LocationDataImpl", 0);//

	private String clazz;
	private int version;

	ReferenceType(String clazz, int version) {
		this.version = version;
		this.clazz = clazz;
	}

	public String getClazz() {
		return clazz;
	}

	public int getVersion() {
		return version;
	}
}
