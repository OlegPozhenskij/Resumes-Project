package com.java.storage;

import com.java.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Object o, Resume r) {
        int index = (Integer) o;
        int indexIns = -index - 1;
        System.arraycopy(storage, indexIns, storage, indexIns + 1, size - indexIns);
        storage[indexIns] = r;
    }

    @Override
    protected void fillDeletedElement(Object o) {
        Integer index = (Integer) o;
        int numMoved = size - index - 1;
        if(numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
