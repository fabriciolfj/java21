package com.github.fabriciolfj.dividifile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.File;
import java.nio.file.Path;
import java.util.Iterator;


public class FindFileDirectorieAndSubDirectories {

    public Iterator<File> find(Path startPath, String extension) {
        if (!extension.startsWith(".")) {
            extension = STR.".\{extension}";
        }

        return FileUtils.iterateFiles(
                startPath.toFile(),
                WildcardFileFilter.builder().setWildcards(STR."*\{extension}").get(),
                TrueFileFilter.INSTANCE);
    }
}
