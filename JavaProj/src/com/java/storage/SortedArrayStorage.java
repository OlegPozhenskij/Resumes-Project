package com.java.storage;

import com.java.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(int index, Resume r) {
        int indexIns = -index - 1;
        System.arraycopy(storage, indexIns, storage, indexIns + 1, size - indexIns);
        storage[indexIns] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if(numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    protected boolean isExist(int index) {
        if(index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
