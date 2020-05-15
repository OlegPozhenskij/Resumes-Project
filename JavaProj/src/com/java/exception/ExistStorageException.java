package com.java.exception;

public class ExistStorageExeption extends StorageExeption {
    public ExistStorageExeption(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}
