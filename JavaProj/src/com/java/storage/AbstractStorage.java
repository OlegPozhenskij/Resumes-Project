package com.java.storage;

import com.java.exception.ExistStorageExeption;
import com.java.exception.NotExistStorageExeption;
import com.java.exception.StorageExeption;
import com.java.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract void doClean();
    protected abstract void doAdd(Object o, Resume r);
    protected abstract boolean checkOverflow();
    protected abstract boolean isExist(Object o);
    protected abstract Object getIndex(String uuid);
    protected abstract void doUpdate(Object o, Resume r);
    protected abstract Resume getElement(Object o);
    protected abstract void doDelete(Object o);
    protected abstract int getSize();
    protected abstract Resume[] getArray();

    @Override
    public void clear() {
        doClean();
    }

    @Override
    public void update(Resume r) {
        Object o = getIndex(r.getUuid());
        if (isExist(o)) {
            doUpdate(o, r);
        } else {
            throw new NotExistStorageExeption(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        Object o = getIndex(r.getUuid());
        if (isExist(o)) {
            update(r);
            throw new ExistStorageExeption(r.getUuid());
        } else if(checkOverflow()) {
            throw new StorageExeption("Storage overflow", r.getUuid());
        } else {
            doAdd(o, r);
        }
    }

    @Override
    public Resume get(String uuid) {
        Object o = getIndex(uuid);
        if(isExist(o)) {
            return getElement(o);
        } else {
            throw new NotExistStorageExeption(uuid);
        }
    }

    @Override
    public void delete(String uuid) {
        Object o = getIndex(uuid);
        if(isExist(o)) {
            doDelete(o);
        } else {
            throw new NotExistStorageExeption(uuid);
        }
    }

    @Override
    public Resume[] getAll() {
        return getArray();
    }

    @Override
    public int size() {
        return getSize();
    }
}
