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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Source object for file.
 * 
 * @author mates
 * 
 */
public class Source implements ISource {

	private File file;

	public Source(File file) {
		this.file = file;
	}

	/**
	 * Opens
	 * <code>InputStream<code> for specified file. Stream must be closed by caller.
	 */
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(file);
	}
}
