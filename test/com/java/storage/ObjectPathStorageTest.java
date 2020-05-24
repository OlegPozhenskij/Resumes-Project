package com.java.storage;

import com.java.storage.serializer.ObjectStreamSerializer;

public class ObjectPathStorageTest extends AbstractStorageTest{
    public ObjectPathStorageTest() {
        super(new PathStorage(STORAGE_DIR_FILE.getAbsolutePath(), new ObjectStreamSerializer()));
    }
}