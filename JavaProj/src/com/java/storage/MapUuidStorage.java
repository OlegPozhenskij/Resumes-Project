package com.java.storage;

import com.java.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doSave(Object searchKey, Resume r) {
        map.put((String) searchKey, r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey((String) searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Object searchKey, Resume r) {
        map.put((String) searchKey, r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey.toString());
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove((String) searchKey);
    }

    @Override
    protected void insertElement(Object o, Resume r) {
        doSave(o, r);
    }

    @Override
    protected void fillDeletedElement(Object o) {
        doDelete(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
