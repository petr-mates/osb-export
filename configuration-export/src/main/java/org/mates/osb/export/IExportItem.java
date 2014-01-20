package org.mates.osb.export;

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

/**
 * Holder for references that should be exported.
 * 
 * @author mates
 */
public interface IExportItem {

	/**
	 * <pre>
	 *  <imp:exportedItemInfo xmlns:imp="http://www.bea.com/wli/config/importexport"  instanceId="TST/AccountSettingsWSProxy" typeId="ProxyService" >
	 * 	  <imp:properties>
	 * 		 <imp:property name="representationversion" value="3000" />
	 * 		 <imp:property name="dataclass" value="com.bea.wli.sb.services.impl.ServiceDefinitionImpl" />
	 * 		 <imp:property name="isencrypted" value="false" />
	 * 		 <imp:property name="jarentryname" value="TST/Account/ProxyService/AccountSettingsWSProxy.ProxyService" />
	 * 		 <imp:property name="extrefs" value="AlertDestination$TST$Common$AlertDestination$HelpdeskEmailDestination" />
	 * 		 <imp:property name="custom _special_data_class" value="com.bea.wli.config.project.impl.LocationDataImpl" />
	 * 	   </imp:properties>
	 *   </imp:exportedItemInfo>
	 * </pre>
	 */

	public static final String REPRESENTATION_VERSION = "representationversion";
	public static final String DATA_CLASS = "dataclass";
	public static final String IS_ENCRYPTED = "isencrypted";
	public static final String JAR_ENTRY_NAME = "jarentryname";
	public static final String EXT_REFS = "extrefs";

	public String getInstanceId();

	public String getTypeId();

	public void setRepresentationVersion(String value);

	public void setDataClass(String value);

	public void setIsEncrypted(String value);

	public void setJarEntry(String value);

	public void setExtRefs(String value);

	public void setProperty(String key, String value);

}
