package com.java.storage;

import com.java.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertElement(Object o, Resume r) {
        storage[size] = r;
    }

    @Override
    protected void fillDeletedElement(Object o) {
        Integer index = (Integer) o;
        storage[index] = storage[size - 1];
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if(storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
