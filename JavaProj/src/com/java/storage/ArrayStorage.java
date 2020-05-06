package com.java.storage;

import com.java.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doAdd(int index, Resume r) {
        storage[size] = r;
    }

    @Override
    protected void doDelete(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void doUpdate(int index, Resume r) {
        storage[size] = r;
        size++;
    }

    protected boolean isExist(int index) {
        if (index != -1)
            return true;
        return false;
    }



    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if(storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
