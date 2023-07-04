package com.opencredo.dillonboardman.kata.serialization;

import java.io.*;
import java.time.ZonedDateTime;

public class Serialized implements Serializable {
    private long serialisationDate;
    private transient ZonedDateTime rehydrationDate;

    public long serialisationDate() {
        return this.serialisationDate;
    }

    public ZonedDateTime rehydrationDate() {
        return this.rehydrationDate;
    }

    @Serial
    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeLong(ZonedDateTime.now().toEpochSecond());
    }

    @Serial
    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        serialisationDate = stream.readLong();
        rehydrationDate = ZonedDateTime.now();
    }
}
