package com.java.storage.serializer;

import com.java.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface StreamSerializerStrategy {
    void doWrite(OutputStream os, Resume r) throws IOException;
    Resume doRead(InputStream is) throws IOException;
}
