package org.mates.osb;

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
