package org.mates.osb.utils;

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
