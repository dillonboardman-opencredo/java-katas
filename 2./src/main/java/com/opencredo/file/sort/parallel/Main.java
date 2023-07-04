package com.opencredo.file.sort.parallel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void sortFileParallel(Path path) throws IOException {
        try (var lines = Files.lines(path)) {
            var sorted = lines.parallel().sorted().toList();
            Files.write(path, sorted);
        }
    }
}