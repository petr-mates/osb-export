package org.mates.osb.xml;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

import junit.framework.Assert;

import org.hamcrest.BaseMatcher;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.w3c.dom.Document;

public class XmlHelperTest {

	@Test
	public void testGetDocumentBuilder() {
		//TODO implement
	}

	@Test
	public void testGetXpath() {
		//TODO implement
	}

	@Test
	public void testGetDOMImplementationRegistry() {
		//TODO implement
	}

	@Test
	public void testWriteToStream() {
		Document newDocument = XmlHelper.getDocumentBuilder().newDocument();
		newDocument.appendChild(newDocument.createElement("root"));
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		XmlHelper.writeToStream(newDocument, stream);
		String xml = new String(stream.toByteArray(), Charset.forName("utf-8"));
		org.junit.Assert.assertThat(xml, CoreMatchers.containsString("root"));
		System.out.println(new String(stream.toByteArray(), Charset.forName("utf-8")));
		System.out.println("test");
	}

}
