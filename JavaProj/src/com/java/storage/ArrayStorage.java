package com.java.storage;

import com.java.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        if (isExist(getIndex(r.getUuid()))) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Resume " + r.getUuid() + " not exist");
        }
    }

    public void save(Resume r) {
        if (isExist(getIndex(r.getUuid()))) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if(size == storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }
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

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(isExist(index)) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume " + uuid + " not exist");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    private boolean isExist(int index) {
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
