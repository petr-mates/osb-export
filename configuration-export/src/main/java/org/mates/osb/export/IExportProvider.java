package org.mates.osb.export;

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

import java.io.IOException;

import org.mates.osb.resources.ReferenceType;

/**
 * An object that implements this interface, provide all resource export.
 * 
 * @author mates
 */
public interface IExportProvider {

	public ReferenceType getReferenceType();

	public IExportItem getExportItem();

	/**
	 * Method should export resource to target directory. Copy content and make
	 * some other customizations.
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public void exportTo(IExportDirectory dir) throws IOException;
}
