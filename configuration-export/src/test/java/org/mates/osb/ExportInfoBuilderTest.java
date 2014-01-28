package org.mates.osb;

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

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Assert;
import org.junit.Test;
import org.mates.osb.export.IExportItem;
import org.mates.osb.xml.XmlHelper;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ExportInfoBuilderTest {

	@Test
	public void testBuild() throws XMLStreamException, SAXException, IOException, XPathExpressionException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5000);
		new ExportInfoBuilder().build(byteArrayOutputStream, Collections.singletonList(getIExportItem()));

		String x = new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));
		System.out.println(x);

		DocumentBuilder documentBuilder = XmlHelper.getDocumentBuilder();
		Document parse = documentBuilder.parse(new InputSource(new StringReader(x)));

		Assert.assertEquals("node",
				getXpath("/xml-fragment/imp:properties/imp:property[@name = 'username']/@value", parse));
		Assert.assertEquals("configuration-export",
				getXpath("/xml-fragment/imp:properties/imp:property[@name = 'description']/@value", parse));
		Assert.assertEquals("Oracle Service Bus",
				getXpath("/xml-fragment/imp:properties/imp:property[@name = 'productname']/@value", parse));
		Assert.assertEquals("11.1.1.5",
				getXpath("/xml-fragment/imp:properties/imp:property[@name = 'productversion']/@value", parse));
		Assert.assertEquals("true",
				getXpath("/xml-fragment/imp:properties/imp:property[@name = 'projectLevelExport']/@value", parse));
		Assert.assertTrue(getXpath("/xml-fragment/imp:properties/imp:property[@name = 'exporttime']/@value", parse)
				.length() > 0);

		Assert.assertEquals("0", getXpath("//imp:property[@name = 'representationversion']/@value", parse));
		Assert.assertEquals("dataclass", getXpath("//imp:property[@name = 'dataclass']/@value", parse));
		Assert.assertEquals("encrypted", getXpath("//imp:property[@name = 'isencrypted']/@value", parse));
		Assert.assertEquals("jarEntry", getXpath("//imp:property[@name = 'jarentryname']/@value", parse));
		Assert.assertEquals("ref", getXpath("//imp:property[@name = 'extrefs']/@value", parse));
		Assert.assertEquals("ref", getXpath("//imp:property[@name = 'extrefs']/@value", parse));
		Assert.assertEquals("instanceId", getXpath("//xml-fragment/imp:exportedItemInfo/@instanceId", parse));
		Assert.assertEquals("typeId", getXpath("/xml-fragment/imp:exportedItemInfo/@typeId", parse));
	}

	private String getXpath(String xpathStr, Document doc) throws XPathExpressionException {
		XPath xpath = XmlHelper.getXpath();
		xpath.setNamespaceContext(new CustomNamespaceContext());
		XPathExpression compile = xpath.compile(xpathStr);
		return compile.evaluate(doc);
	}

	public IExportItem getIExportItem() {
		return new IExportItem() {

			@Override
			public String getTypeId() {
				return "typeId";
			}

			@Override
			public String getRepresentationVersion() {
				return "0";
			}

			@Override
			public Map<String, String> getProperties() {
				return new HashMap<String, String>();
			}

			@Override
			public String getJarEntry() {
				return "jarEntry";
			}

			@Override
			public String getIsEncrypted() {
				return "encrypted";
			}

			@Override
			public String getInstanceId() {
				return "instanceId";
			}

			@Override
			public List<String> getExtRefs() {
				return Collections.singletonList("ref");
			}

			@Override
			public String getDataClass() {
				return "dataclass";
			}

			@Override
			public void addExtRefs(String value) {
			}

			@Override
			public void putProperty(String key, String value) {

			}
		};
	}

	private static class CustomNamespaceContext implements NamespaceContext {

		private static final String XSD_PREFIX = "imp";
		private static final List<String> NS = Arrays.asList(new String[] { ExportInfoBuilder.WL_OSB_EXPORT });

		@Override
		public String getNamespaceURI(String prefix) {
			if (XSD_PREFIX.equals(prefix)) {
				return ExportInfoBuilder.WL_OSB_EXPORT;
			}
			return XMLConstants.NULL_NS_URI;
		}

		@Override
		public String getPrefix(String namespaceURI) {
			if (ExportInfoBuilder.WL_OSB_EXPORT.equals(namespaceURI)) {
				return XSD_PREFIX;
			}
			return null;
		}

		@Override
		public Iterator<?> getPrefixes(String namespaceURI) {
			return NS.iterator();
		}
	}
}
