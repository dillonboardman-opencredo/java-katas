package com.opencredo.file.sort.concurrent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void sortFile(Path path) throws IOException {
        try (var lines = Files.lines(path)) {
            var sorted = lines.sorted().toList();
            Files.write(path, sorted);
        }
    }
}