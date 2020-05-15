package com.java.storage;

import com.java.exception.ExistStorageException;
import com.java.exception.NotExistStorageException;
import com.java.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    protected abstract void doSave(SK searchKey, Resume r);
    protected abstract boolean isExist(SK searchKey);
    protected abstract SK getSearchKey(String uuid);
    protected abstract void doUpdate(SK searchKey, Resume r);
    protected abstract Resume doGet(SK searchKey);
    protected abstract void doDelete(SK searchKey);
    protected abstract void insertElement(SK o, Resume r);
    protected abstract void fillDeletedElement(SK o);
    protected abstract List<Resume> doCopyAll();

    @Override
    public void update(Resume r) {
        SK searchKey = getExistedSearchKey(r.getUuid());
        doUpdate(searchKey, r);
    }

    @Override
    public void save(Resume r) {
        SK searchKey = getNotExistedSearchKey(r.getUuid());
        doSave(searchKey, r);
    }

    @Override
    public Resume get(String uuid) {
        SK searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void delete(String uuid) {
        SK searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if(!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if(isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }
}
