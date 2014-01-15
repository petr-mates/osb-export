package org.mates.osb.resources;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
