package com.java.storage;

import com.java.exception.StorageException;
import com.java.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
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
    protected void doUpdate(Integer index, Resume r) {
        storage[index] = r;
    }

    @Override
    protected void doSave(Integer index, Resume r) {
        if(checkOverflow()) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(index, r);
            size++;
        }
    }

    @Override
    protected Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    @Override
    protected void doDelete(Integer index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }
}
