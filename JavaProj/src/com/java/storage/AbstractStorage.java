package com.java.storage;

import com.java.exception.ExistStorageExeption;
import com.java.exception.NotExistStorageExeption;
import com.java.exception.StorageExeption;
import com.java.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract void doAdd(Object searchKey, Resume r);
    protected abstract boolean isExist(Object searchKey);
    protected abstract Object getSearchKey(String uuid);
    protected abstract void doUpdate(Object searchKey, Resume r);
    protected abstract Resume getElement(Object searchKey);
    protected abstract void doDelete(Object searchKey);

    @Override
    public void update(Resume r) {
        Object searchKey = getExistedSearchKey(r.getUuid());
        doUpdate(searchKey, r);
    }

    @Override
    public void save(Resume r) {
        Object searchKey = getNotExistedSearchKey(r.getUuid());
        doAdd(searchKey, r);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        return getElement(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if(!isExist(searchKey)) {
            throw new NotExistStorageExeption(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if(isExist(searchKey)) {
            throw new ExistStorageExeption(uuid);
        }
        return searchKey;
    }
}
