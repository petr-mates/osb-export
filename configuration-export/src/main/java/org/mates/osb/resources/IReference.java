package org.mates.osb.resources;

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

/**
 * Holder for resource references.
 * @author mates
 */
public interface IReference {

	/**
	 * Holds type of resource to which this resource refers.
	 * @return
	 */
	public ResourceType getType();

	/**
	 * Path to reference. Reference is normalized path to referenced resource.
	 * Directories are separated with '/'
	 * @return
	 */
	public String getPath();
}
