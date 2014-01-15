package org.mates.osb;

import java.io.IOException;
import java.io.InputStream;

public interface ISource {

	public InputStream getInputStream() throws IOException;
}
