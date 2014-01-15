package org.mates.osb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Source implements ISource {

	private File file;

	public Source(File file) {
		this.file = file;
	}

	public InputStream getInputStream() throws IOException {
		return new FileInputStream(file);
	}
}
