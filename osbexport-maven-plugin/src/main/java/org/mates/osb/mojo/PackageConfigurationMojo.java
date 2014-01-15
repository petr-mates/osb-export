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
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.mates.osb.ZipFile;

/**
 * Goal packages configuration from (output directory)/osb-conf to ${name}.
 * 
 */
@Mojo(name = "package", defaultPhase = LifecyclePhase.PACKAGE)
public class PackageConfigurationMojo extends AbstractMojo {

	/**
	 * source directory to be scanned. - default=${project.basedir}.
	 * -DsourceDir=...
	 */
	@Parameter(defaultValue = "${project.basedir}", property = "sourceDir", required = true)
	private File sourceDir;

	/**
	 * build output directory. - default=${project.build.directory}/osb-conf.
	 * -DoutputDir=...
	 */
	@Parameter(defaultValue = "${project.build.directory}/osb-conf", property = "outputDir", required = false)
	private File outputDirectory;

	/**
	 * name of the final artifact. -
	 * default=${project.build.finalName}.${project.packaging}.
	 * -Dosbexport.name=...
	 */
	@Parameter(defaultValue = "${project.build.finalName}.${project.packaging}", property = "osbexport.name", required = true)
	private String name;

	/**
	 * maven helper for attachArtifact. used in install phase.
	 * -Dcustomize.fileName=...
	 */
	@Component
	private MavenProjectHelper mavenProjectHelper;

	/**
	 * MavenProject - component, internal usage.
	 */
	@Component
	private MavenProject mavenProject;

	private Log log;

	@Override
	public void setLog(Log aLog) {
		super.setLog(aLog);
		this.log = aLog;
	}

	public void execute() throws MojoExecutionException {
		debugParams();
		File directory = new File(mavenProject.getBuild().getDirectory());

		File target = new File(directory, name);
		try {
			new ZipFile().createZipFile(target, outputDirectory);
		} catch (IOException e) {
			throw new MojoExecutionException("error creating zip file", e);
		}
		mavenProjectHelper.attachArtifact(mavenProject, "conf", target);
	}
	
	private void debugParams(){		
		log.debug("osbexport-package sourceDir " + sourceDir);
		log.debug("osbexport-package name " + name);
		log.debug("osbexport-package outputDirectory " + outputDirectory);
	}
	
}
