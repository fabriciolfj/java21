package com.gifthub.fabriciolfj.dividirfile;

import com.github.fabriciolfj.dividifile.SplitLargeFile;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class SplitLargeFileTest {

    @BeforeAll
    static void prepareData() throws IOException {
        Files.createDirectories(Paths.get("target/split"));
    }

    private String splitFileDirPath() throws Exception {
        return STR."\{Paths.get("target")}/split";
    }

    private Path largeFilePath() throws Exception {
        return Paths.get(Objects.requireNonNull(this.getClass().getClassLoader().getResource("large-file.txt")).toURI());
    }

    @Test
    void givenLargeFile_whenSplitLargeFile_thenSplitBySize() throws Exception {
        final File input = largeFilePath().toFile();
        final SplitLargeFile slf = new SplitLargeFile();
        slf.splitByFileSize(input, 1024_000, splitFileDirPath());
    }


    @Test
    void giveLargeFile_whenSplitLargeFile_then5Parts() throws Exception {
        final File input = largeFilePath().toFile();
        final SplitLargeFile slf = new SplitLargeFile();
        slf.splitByNumberOrFiles(input, 5, splitFileDirPath());
    }
}
