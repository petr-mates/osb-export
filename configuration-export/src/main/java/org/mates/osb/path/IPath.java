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

public interface IPath {

	/**
	 * Adds last child to path.
	 * 
	 * @param name
	 */
	public void addChild(String name);

	/**
	 * Builds path from root to last child. Items are separated by separator
	 * string.
	 * 
	 * @param separator
	 * @return
	 */
	public String buildPath(String separator);

	/**
	 * Array of string. each element represents one resource in path. root
	 * project should be at first position.
	 * 
	 * @return
	 */
	public String[] toArray();

}
