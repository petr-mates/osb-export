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

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

import org.hamcrest.CoreMatchers;
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
