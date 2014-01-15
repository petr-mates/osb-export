package org.mates.osb.path;

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
