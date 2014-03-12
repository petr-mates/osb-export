package org.mates.osb.xml;

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

import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

public final class XmlHelper {

	private XmlHelper() {
	}

	public static DocumentBuilder getDocumentBuilder() {
		DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
		newInstance.setNamespaceAware(true);
		newInstance.setIgnoringElementContentWhitespace(true);
		try {
			return newInstance.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new XmlException("document builder was not created", e);
		}
	}

	public static XPath getXpath() {
		XPathFactory newInstance = XPathFactory.newInstance();
		return newInstance.newXPath();
	}

	protected static DOMImplementationRegistry getDOMImplementationRegistry() {
		try {
			return DOMImplementationRegistry.newInstance();
		} catch (ClassNotFoundException e) {
			throw new XmlException("DomImplementaion problem");
		} catch (InstantiationException e) {
			throw new XmlException("DomImplementaion problem");
		} catch (IllegalAccessException e) {
			throw new XmlException("DomImplementaion problem");
		}
	}

	public static void writeToStream(Document aDoc, OutputStream aOut) {
		DOMImplementationRegistry registry = getDOMImplementationRegistry();

		final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
		final LSSerializer writer = impl.createLSSerializer();

		writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);

		LSOutput output = impl.createLSOutput();
		output.setEncoding("UTF-8");

		output.setByteStream(aOut);
		writer.write(aDoc, output);

	}
}
