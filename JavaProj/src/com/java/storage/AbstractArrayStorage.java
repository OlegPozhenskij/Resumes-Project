package com.java.storage;

import com.java.exception.ExistStorageExeption;
import com.java.exception.NotExistStorageExeption;
import com.java.exception.StorageExeption;
import com.java.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void fillDeletedElement(Object o);
    protected abstract boolean isExist(Object o);
    protected abstract Object getIndex(String uuid);
    protected abstract void insertElement(Object o, Resume r);

    @Override
    protected void doClean() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected boolean checkOverflow() {
        return size == storage.length;
    }

    @Override
    protected void doUpdate(Object o, Resume r) {
        storage[(Integer) o] = r;
    }

    @Override
    protected void doAdd(Object o, Resume r) {
        insertElement(o, r);
        size++;
    }

    @Override
    protected Resume getElement(Object o) {
        return storage[(Integer) o];
    }

    @Override
    protected void doDelete(Object o) {
        fillDeletedElement(o);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected int getSize() {
        return size;
    }

    @Override
    protected Resume[] getArray() {
        return Arrays.copyOf(storage, size);
    }
}
