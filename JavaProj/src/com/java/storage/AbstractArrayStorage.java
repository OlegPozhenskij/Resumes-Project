package com.java.storage;

import com.java.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if(isExist(index)) {
            return storage[index];
        } else {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
    }

    protected abstract boolean isExist(int index);

    protected abstract int getIndex(String uuid);

}
