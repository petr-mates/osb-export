package org.mates.osb.path;

import java.util.ArrayList;
import java.util.List;

public class Path implements IPath {

	private List<String> path = new ArrayList<String>();

	public Path(String rootName) {
		path.add(rootName);
	}

	public void addChild(String name) {
		path.add(name);

	}

	public String buildPath(String separator) {
		StringBuilder sb = new StringBuilder();
		for (String item : path) {
			sb.append(item);
			sb.append(separator);
		}
		return sb.substring(0, sb.length() - separator.length());
	}

	public String[] toArray() {
		return path.toArray(new String[path.size()]);
	}

}
