package org.mates.osb.xsd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.mates.osb.xml.XmlException;
import org.mates.osb.xml.XmlHelper;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SchemaScanner {

	private Document doc;

	protected Document getDocument() {
		return doc;
	}

	public SchemaScanner(Document doc) {
		this.doc = doc;
	}

	public List<ISchemaLocation> getImportLocations() {
		ArrayList<ISchemaLocation> result = new ArrayList<ISchemaLocation>();
		NodeList nl;
		nl = findNodes("//xsd:import[@schemaLocation]");
		for (int i = 0; i < nl.getLength(); i++) {
			Node item = nl.item(i);
			String location = getNamesAttribute(item, "schemaLocation");
			String namespace = getNamesAttribute(item, "namespace");
			result.add(new SchemaImport(namespace, location));
		}
		return result;
	}

	public List<String> getIncludeLocations() {
		ArrayList<String> result = new ArrayList<String>();
		NodeList nl;
		nl = findNodes("//xsd:include[@schemaLocation]");
		for (int i = 0; i < nl.getLength(); i++) {
			Node item = nl.item(i);
			String schemaLocation = getNamesAttribute(item, "schemaLocation");
			result.add(schemaLocation);
		}
		return result;
	}

	private String getNamesAttribute(Node item, String attrName) {
		NamedNodeMap attributes = item.getAttributes();
		return attributes.getNamedItem(attrName).getNodeValue();
	}

	public String getTargetNamespace() {
		NodeList nl = findNodes("/xsd:schema[@targetNamespace]");
		if (nl.getLength() > 0) {
			return getNamesAttribute(nl.item(0), "targetNamespace");
		}
		return "";
	}

	protected NodeList findNodes(String stringXpath) {
		XPathExpression expression;
		NodeList nl;
		try {
			XPath xpath = XmlHelper.getXpath();
			xpath.setNamespaceContext(new CustomNamespaceContext());
			expression = xpath.compile(stringXpath);
			nl = (NodeList) expression.evaluate(getDocument(), XPathConstants.NODESET);
			return nl;
		} catch (XPathExpressionException e) {
			throw new XmlException("cannot search document with xpath", e);
		}
	}

	private static class CustomNamespaceContext implements NamespaceContext {

		private static final String XSD_PREFIX = "xsd";
		private static final List<String> NS = Arrays.asList(new String[] { XMLConstants.W3C_XML_SCHEMA_NS_URI });

		@Override
		public String getNamespaceURI(String prefix) {
			if (XSD_PREFIX.equals(prefix)) {
				return XMLConstants.W3C_XML_SCHEMA_NS_URI;
			}
			return XMLConstants.NULL_NS_URI;
		}

		@Override
		public String getPrefix(String namespaceURI) {
			if (XMLConstants.W3C_XML_SCHEMA_NS_URI.equals(namespaceURI)) {
				return XSD_PREFIX;
			}
			return null;
		}

		@Override
		public Iterator<?> getPrefixes(String namespaceURI) {
			return NS.iterator();
		}
	}

	private static class SchemaImport implements ISchemaLocation {

		SchemaImport(String namespace, String location) {
			this.namespace = namespace;
			this.location = location;
		}

		private String namespace;
		private String location;

		@Override
		public String getSchemaLocation() {
			return location;
		}

		@Override
		public String getNamespace() {
			return namespace;
		}
	}
}
