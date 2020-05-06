package com.java.storage;

import com.java.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;
    
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (isExist(index)) {
            //
        } else {
            System.out.println("Resume " + r.getUuid() + " not exist");
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (isExist(index)) {
            update(r);
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if(size == storage.length) {
            System.out.println("Storage overflow");
        } else {
            insertElement(index, r);
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
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume " + uuid + " not exist");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }
    
    public int size() {
        return size;
    }
    
    protected abstract void insertElement(int index, Resume r);
    
    protected abstract void fillDeletedElement(int index);
    
    protected abstract boolean isExist(int index);

    protected abstract int getIndex(String uuid);
}
