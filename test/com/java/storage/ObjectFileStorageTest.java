package com.java.storage;

import com.java.storage.serializer.ObjectStreamSerializer;

public class ObjectFileStorageTest extends AbstractStorageTest {
    public ObjectFileStorageTest() {
        super(new FileStorage(STORAGE_DIR_FILE, new ObjectStreamSerializer()));
    }
}