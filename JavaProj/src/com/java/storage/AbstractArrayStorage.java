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
    protected abstract void insertElement(Object o, Resume r);

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    private boolean checkOverflow() {
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

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        int key = (Integer)getKey(uuid);
        if(checkOverflow()) {
            throw new StorageExeption("Storage overflow", uuid);
        } else {
            return key;
        }
    }

    protected abstract Object getKey(String uuid);
}
