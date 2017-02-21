package com.epam.memoryleak;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    private static final String FILE_NAME = "data.txt";
    private static final List<String> STRINGS = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {

        // causes memory leak, as STRINGS is not collected
        // readLinesToMemberList(FILE_NAME);

        readLinesToLocalList(FILE_NAME);

        Thread.sleep(TimeUnit.SECONDS.toMillis(60));
    }

    private static void readLinesToMemberList(String fileName) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileName));
        lines.forEach(line -> STRINGS.add(line.substring(0, 3)));
    }

    private static void readLinesToLocalList(String fileName) throws IOException {
        List<String> localStrings = new ArrayList<>();

        Stream<String> lines = Files.lines(Paths.get(fileName));
        lines.forEach(line -> localStrings.add(line.substring(0, 3)));
    }
}
