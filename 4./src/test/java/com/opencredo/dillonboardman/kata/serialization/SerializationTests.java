package com.opencredo.dillonboardman.kata.serialization;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializationTests {
    File file = new File("object");

    @AfterEach
    void destroy() throws IOException {
        Files.deleteIfExists(file.toPath());
    }

    @Test
    @DisplayName("Test for expectedSerialisationDate")
    public void testSerialisationDate() throws IOException {
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            out.writeObject(new Serialized());
        }

        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            var object = (Serialized) in.readObject();
            var expectedSerialisationDate = ZonedDateTime.now().toEpochSecond();
            assertEquals(expectedSerialisationDate, object.serialisationDate());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Test for rehydrationDate")
    public void testRehydrationDate() throws IOException {
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            out.writeObject(new Serialized());
        }

        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            var object = (Serialized) in.readObject();
            var expectedRehydrationDate = ZonedDateTime.now().toLocalDate();
            assert(expectedRehydrationDate.equals(object.rehydrationDate().toLocalDate()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
