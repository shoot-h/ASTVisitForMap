package util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {
    public static String readFile(final String path){
        String value=null;
        try {
            value = Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.joining(System.getProperty("line.separator")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
    public static List<String> findFiles(String dirRoot, String ext, String extIgnore) {
        List<String> pathsFile = new ArrayList<String>();
        try {
            pathsFile.addAll(
                    Files.walk(Paths.get(dirRoot))
                            .map(Path::toString)
                            .filter(p -> p.endsWith(ext))
                            .filter(p -> !p.contains(extIgnore))
                            .map(p -> p.replace("\\", "/"))
                            .collect(Collectors.toList())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathsFile;
    }

    public static List<String> findFiles(String dirRoot, String ext) {
        List<String> pathsFile = new ArrayList<String>();
        try {
            pathsFile.addAll(
                    Files.walk(Paths.get(dirRoot))
                            .map(Path::toString)
                            .filter(p -> p.endsWith(ext))
                            .collect(Collectors.toList())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathsFile;
    }


    public static List<String> findFiles(String[] dirsRoot, String ext, String extIgnore) {
        List<String> pathsFile = new ArrayList<String>();
        try {
            for(String dirRoot: dirsRoot) {
                pathsFile.addAll(
                        Files.walk(Paths.get(dirRoot))
                                .map(Path::toString)
                                .filter(p -> p.endsWith(ext))
                                .filter(p -> !p.contains(extIgnore))
                                .collect(Collectors.toList())
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathsFile;
    }

}
