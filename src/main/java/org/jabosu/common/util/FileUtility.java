package org.jabosu.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author satya
 */
public class FileUtility {
    
    private static Logger logger = LoggerFactory.getLogger(FileUtility.class.getName());
    
    public static File mergeFiles(String dir, String fname, File[] files) {
        File ofile = new File(new File(dir), fname);
        FileOutputStream fos = null;
        FileInputStream fis = null;
        byte[] fileBytes;
        int bytesRead = 0;

        try {

            fos = new FileOutputStream(ofile, true);
            for (File file : files) {
                fis = new FileInputStream(file);
                fileBytes = new byte[(int) file.length()];
                bytesRead = fis.read(fileBytes, 0, (int) file.length());
                assert (bytesRead == fileBytes.length);
                assert (bytesRead == (int) file.length());
                fos.write(fileBytes);
                fos.flush();
                fileBytes = null;

                fis.close();
                fis = null;

                file.delete(); //delete the part file
            }

            fos.close();
            fos = null;

        } catch (Exception e) {
            logger.error("Error in merging files", e);
            return null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    logger.warn("warning", ex);
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    logger.warn("warning", ex);
                }
            }
        }

        return ofile;

    }

    public static File[] getPartFiles(File dir, final String filename) {

        String part = filename + ".part0";

        List<File> parts = new ArrayList<File>();

        File partFile = new File(dir, part);

        int counter = 0;
        while (partFile.exists()) {
            parts.add(partFile);

            counter++;
            partFile = new File(dir, filename + ".part" + counter);

        }

        return parts.toArray(new File[0]);

    }

    public static String getMimeType(File file) {
        String mimeType = null;
        try {
            Tika tika = new Tika();
            mimeType = tika.detect(file);
            System.out.println("File type ::: " + mimeType);
        } catch (IOException e) {
            logger.error("Error getting mimetype for file : " + file.getAbsolutePath(), e);
        }
        return mimeType;
    }
}
