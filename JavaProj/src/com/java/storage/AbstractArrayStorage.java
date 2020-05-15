package com.java.storage;

import com.java.exception.StorageException;
import com.java.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    private boolean checkOverflow() {
        return size == storage.length;
    }

    @Override
    protected void doUpdate(Object index, Resume r) {
        storage[(Integer) index] = r;
    }

    @Override
    protected void doSave(Object index, Resume r) {
        if(checkOverflow()) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(index, r);
            size++;
        }
    }

    @Override
    protected Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer)index >= 0;
    }

    @Override
    protected void doDelete(Object index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }
}
