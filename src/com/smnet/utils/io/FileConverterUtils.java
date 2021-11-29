package com.smnet.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class FileConverterUtils {

    public static String toBase64String(File file) throws IOException {

        final FileInputStream fileInputStream = new FileInputStream(file);

        final int fileLength = (int) file.length();

        byte[] bytes = new byte[fileLength];

        fileInputStream.read(bytes);

        return new String(Base64.getEncoder().encode(bytes));
    }

    public static void fromBase64String(String base64, File targetFile) throws IOException {

        final byte[] bytes = base64.getBytes();

        final byte[] decodedBytes = Base64.getDecoder().decode(bytes);

        final FileOutputStream fileOutputStream = new FileOutputStream(targetFile);

        fileOutputStream.write(decodedBytes);
    }
}
