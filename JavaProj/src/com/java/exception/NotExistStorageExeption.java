package com.java.exception;

public class NotExistStorageExeption extends StorageExeption {
    public NotExistStorageExeption(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
