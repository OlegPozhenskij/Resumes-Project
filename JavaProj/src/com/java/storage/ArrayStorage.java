package com.java.storage;

import com.java.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertElement(Object o, Resume r) {
        storage[size] = r;
    }

    @Override
    protected boolean isExist(Object o) {
        if ((Integer)o != -1)
            return true;
        return false;
    }

    @Override
    protected void fillDeletedElement(Object o) {
        Integer index = (Integer) o;
        storage[index] = storage[size - 1];
    }


    @Override
    protected Object getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if(storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
