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

public enum ResourceType {

	/**
	 * Root resource - Project
	 */
	PROJECT,
	/**
	 * Project Folder
	 */
	FOLDER,
	/**
	 * ProxyService
	 */
	PROXY("proxy"),
	/**
	 * BussinesService
	 */
	BIZ("biz"),
	/**
	 * Xml resource
	 */
	XML("xml"),
	/**
	 * Xml schema resource
	 */
	XSD("xsd"),
	/**
	 * web service definition
	 */
	WSDL("wsdl"),
	/**
	 * osb flow definition
	 */
	FLOW("flow"),
	/**
	 * Service account
	 */
	ACCOUNT("sa"),
	/**
	 * Service Provider
	 */
	PROVIDER("skp"),
	/**
	 * Alert destination
	 */
	ALERT("alert");

	private String extenstion;

	ResourceType(String extension) {
		this.extenstion = extension;
	}

	ResourceType() {
		this.extenstion = "";
	}

	public String getExtension() {
		return extenstion;
	}

	public static ResourceType getTypeByExtension(String extension) {
		for (ResourceType resourceType : values()) {
			if (resourceType.getExtension().equals(extension)) {
				return resourceType;
			}
		}
		return null;
	}
}
