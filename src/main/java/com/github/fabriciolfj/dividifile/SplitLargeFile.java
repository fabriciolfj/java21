package com.github.fabriciolfj.dividifile;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SplitLargeFile {

    public List<File> splitByNumberOrFiles(final File largeFile, int noOfFiles, final String splitFileDirPath) throws IOException {
        return splitByFileSize(largeFile, getSizeInBytes(largeFile.length(), noOfFiles), splitFileDirPath);
    }

    public List<File> splitByFileSize(final File largeFile, final int maxSizeOfSplitFiles, final String splitFileDirPath) throws IOException {
        final List<File> listOfSplitFiles = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(largeFile)) {
            final byte[] buffer = new byte[maxSizeOfSplitFiles];
            int read = inputStream.read(buffer);

            while (read > -1) {
                var file = getSplitFile(largeFile.getName(), buffer, maxSizeOfSplitFiles, splitFileDirPath);
                listOfSplitFiles.add(file);

                read = inputStream.read(buffer);
            }
        }

        return listOfSplitFiles;
    }

    private int getSizeInBytes(long largeFileInBytes, int numberOfFilesPorSplit) {
        if((largeFileInBytes / numberOfFilesPorSplit) != 0) {
            largeFileInBytes = ((largeFileInBytes / numberOfFilesPorSplit) + 1) * numberOfFilesPorSplit;
        }

        long x = largeFileInBytes / numberOfFilesPorSplit;

        if (x > Integer.MAX_VALUE) {
            throw new NumberFormatException("size too large");
        }

        return (int) x;
    }

    private File getSplitFile(final String largeFileName, byte[] buffer, int length, String splitFileDirPath) throws IOException {
        final File splitFile = File.createTempFile(removeExtension(largeFileName) + "-", "-split", new File(splitFileDirPath));

        try(FileOutputStream fos = new FileOutputStream(splitFile)) {
            fos.write(buffer, 0, length);
        }

        return splitFile;
    }

    private static String removeExtension(final String name) {
        return name.replace(".txt", "");
    }
}
