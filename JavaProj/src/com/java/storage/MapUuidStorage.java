package com.java.storage;

import com.java.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doSave(String searchKey, Resume r) {
        map.put(searchKey, r);
    }

    @Override
    protected boolean isExist(String searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(String searchKey, Resume r) {
        map.put(searchKey, r);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return map.get(searchKey.toString());
    }

    @Override
    protected void doDelete(String searchKey) {
        map.remove(searchKey);
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
