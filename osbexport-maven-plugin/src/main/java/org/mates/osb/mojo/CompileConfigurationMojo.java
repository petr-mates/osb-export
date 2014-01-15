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

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Goal exports all projects from source directory to (output directory)/osb-conf.
 * 
 */
@Mojo(name = "compile", defaultPhase = LifecyclePhase.COMPILE)
public class CompileConfigurationMojo extends AbstractMojo {

    /**
     * build output directory. - default=${project.build.directory}/osb-conf.
     * -DoutputDir=...
     */
    @Parameter(defaultValue = "${project.build.directory}/osb-conf", property = "outputDir", required = true)
    private File outputDirectory;

    /**
     * directory excluded from scan. - default=target
     * -DexcludeDir=...
     */
    @Parameter(defaultValue = "target", property = "excludeDir", required = false)
    private String excludeDir;

    /**
     * source directory to be scanned. - default=${project.basedir}.
     * -DsourceDir=...
     */
    @Parameter(defaultValue = "${project.basedir}", property = "sourceDir", required = true)
    private File sourceDir;

    /**
     * 
     */
    @Parameter(property = "ignoredDirs", required = false)
    private String[] ignoredDirs = new String[0];
    
    private Log log;

    public void execute() throws MojoExecutionException {
        File destDir = outputDirectory;
        if (new File(destDir, "ExportInfo").exists()) {
            log.info("ExportInfo exists .... return");
            return;
        }

        
    }

    @Override
    public void setLog(Log aLog) {
        super.setLog(aLog);
        this.log = aLog;
    }
}
