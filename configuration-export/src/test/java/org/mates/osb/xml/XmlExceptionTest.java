package org.mates.osb.xml;

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
