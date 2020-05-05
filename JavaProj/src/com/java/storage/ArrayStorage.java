package com.java.storage;

import com.java.model.Resume;

public class ArrayStorage {

    private Resume[] storage = new Resume[5];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume r) {
        if(resumeExist(r.getUuid()) == -1) {
            System.out.println("Resume is not exist");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public void save(Resume r) {
        if(resumeExist(r.getUuid()) == -1) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Resume is already exist");
        }
    }

    public Resume get(String uuid) {
        int i = resumeExist(uuid);
        if(i == -1) {
            System.out.println("Resume is not exist");
            return null;
        } else {
            return storage[i];
        }
    }

    public void delete(String uuid) {
        int i = resumeExist(uuid);
        if(i == -1) {
            System.out.println("Resume is not exist");
        } else {
            storage[i] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    private int  resumeExist(String uuid) {
        for (int i = 0; i < size; i++) {
            if(storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

}
