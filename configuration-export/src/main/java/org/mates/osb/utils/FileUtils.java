package org.mates.osb.utils;

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

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

public final class FileUtils {

	private FileUtils() {
	}

	public static String getExtension(File file) {
		String name = file.getName();
		int lastIndexOf = name.lastIndexOf('.');
		if (lastIndexOf > -1) {
			return name.substring(lastIndexOf + 1);
		}
		return "";
	}

	public static void closeQuietly(Closeable what) {
		if (what != null) {
			try {
				what.close();
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}

	public static String getBaseName(String name) {
		return FilenameUtils.getBaseName(name);
	}
}
