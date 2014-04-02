package org.mates.osb;

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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils; 

public class ZipFile {

    /**
     * recursive scans directory
     * 
     * @param aParent
     * @return
     * @throws IOException
     */
    private List<File> getFiles(File aParent) throws IOException {
        List<File> files = new ArrayList<File>();
        for (File f : aParent.listFiles()) {
            if (f.isDirectory()) {
                files.addAll(getFiles(f));
            } else {
                files.add(f.getCanonicalFile());
            }
        }
        return files;
    }

    /**
     * scans directory and creates file with all files in directory
     * 
     * @param aTarget
     * @param aParentDir
     * @throws IOException
     */
    public void createZipFile(File aTarget, File aParentDir) throws IOException {
        ZipOutputStream zous = null;
        try {
            FileOutputStream fous = new FileOutputStream(aTarget);
            zous = new ZipOutputStream(fous);
            List<File> files = getFiles(aParentDir.getCanonicalFile());
            int dirLengh = aParentDir.getCanonicalPath().length();
            for (File file : files) {
                String substring = file.getPath().substring(dirLengh);
                /*
                 * remove leading \ or /
                 */
                if (substring.charAt(0) == '\\' || substring.charAt(0) == '/') {
                    substring = substring.substring(1);
                }
                ZipEntry zipEntry = new ZipEntry(substring);
                zous.putNextEntry(zipEntry);
                FileInputStream fin = null;
                try {
                    fin = new FileInputStream(file);
                    IOUtils.copy(fin, zous);
                } finally {
                    IOUtils.closeQuietly(fin);
                }
            }
        } finally {
            IOUtils.closeQuietly(zous);
        }
    }
}
