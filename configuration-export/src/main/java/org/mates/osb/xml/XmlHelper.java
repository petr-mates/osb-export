package org.mates.osb.xml;

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
		} catch (ReflectiveOperationException e) {
			throw new XmlException("DomImplementaion problem", e);
		}
	}

	public static void writeToFile(Document aDoc, OutputStream aOut) {
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
