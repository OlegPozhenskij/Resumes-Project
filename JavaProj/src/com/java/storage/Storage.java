package com.java.storage;

import com.java.model.Resume;

import java.util.Arrays;

public interface Storage {
    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll() ;

    int size();
}