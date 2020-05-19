package com.java.storage;

import com.java.ResumeTestData;
import com.java.exception.StorageException;
import com.java.model.Resume;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(ResumeTestData.comleteResume(UUID.randomUUID().toString(), "name" + i));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(ResumeTestData.comleteResume(UUID.randomUUID().toString(), "error"));
    }
}