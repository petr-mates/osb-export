package org.mates.osb.mojo;

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

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Ignore;
import org.junit.Test;
import org.mates.osb.export.IExportDirectory;

public class CompileConfigurationMojoTest {

	@Test
	@Ignore
	public void testProcessProjects() throws MojoExecutionException {
		CompileConfigurationMojo compileConfigurationMojo = new CompileConfigurationMojo() {
			@Override
			protected IExportDirectory getExportDirectory() {
				return new IExportDirectory() {

					@Override
					public File getExportDir() {
						return new File("./target/mojo-test/");
					}
				};
			}
		};
		compileConfigurationMojo.processProjects(new File("d:\\svn\\osb\\trunk\\configuration"));
	}
}
