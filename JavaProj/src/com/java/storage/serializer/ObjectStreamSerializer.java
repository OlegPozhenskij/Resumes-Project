package com.java.storage.serializer;

import com.java.exception.StorageException;
import com.java.model.Resume;
import com.java.storage.serializer.StreamSerializerStrategy;

import java.io.*;

public class ObjectStreamSerializer implements StreamSerializerStrategy {

    @Override
    public void doWrite(OutputStream os, Resume r) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(r);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Coudn't read file", e);
        }
    }
}
