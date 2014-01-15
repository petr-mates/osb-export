package org.mates.osb.xml;

public class XmlException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5105286661772809722L;

	public XmlException() {
	}

	public XmlException(String message) {
		super(message);
	}

	public XmlException(String message, Throwable throThrowable) {
		super(message, throThrowable);
	}

}
