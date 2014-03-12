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

import org.junit.Assert;
import org.junit.Test;

public class XmlExceptionTest {

	@Test
	public void testXmlException() {
		XmlException xmlException = new XmlException();
		Assert.assertNotNull(xmlException);
	}

	@Test
	public void testXmlExceptionString() {
		XmlException xmlException = new XmlException("exception message");
		Assert.assertEquals("exception message", xmlException.getMessage());
	}

	@Test
	public void testXmlExceptionStringThrowable() {
		Exception exception = new Exception();
		XmlException xmlException = new XmlException("exception message", exception);
		Assert.assertEquals("exception message", xmlException.getMessage());
		Assert.assertTrue(exception == xmlException.getCause());
	}

}
