package com.opencredo.file.sort.concurrent;


import com.opencredo.file.sort.concurrent.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {
    Path sorted = Path.of("sorted.csv");
    Path unsorted = Path.of("unsorted.csv");

    @BeforeEach
    void create() throws IOException {
        Files.createFile(sorted);
        Files.createFile(unsorted);
        Files.write(sorted, List.of("\"Boardman Dillon\", \"18/07/1989\"", "\"Dillon Boardman\", \"18/07/1998\""));
        Files.write(unsorted, List.of("\"Dillon Boardman\", \"18/07/1998\"", "\"Boardman Dillon\", \"18/07/1989\""));
    }

    @AfterEach
    void destroy() throws IOException {
        Files.deleteIfExists(sorted);
        Files.deleteIfExists(unsorted);
    }

    @Test
    @DisplayName("Test for sortFile() static method in Main")
    public void testSortFile() throws IOException {
        Main.sortFile(unsorted);
        assertEquals(Files.readAllLines(unsorted), Files.readAllLines(sorted));
    }
}
