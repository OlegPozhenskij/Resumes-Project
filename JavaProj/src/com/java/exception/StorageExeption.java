package com.java.exception;

public class StorageExeption extends RuntimeException {
    private final String uuid;

    public StorageExeption(String uuid, String message) {
        super(message);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
