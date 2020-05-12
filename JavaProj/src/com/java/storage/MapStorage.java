package com.java.storage;

import com.java.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doSave(Object searchKey, Resume r) {
        insertElement(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        if(map.containsKey((String) searchKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey().equals(uuid)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Object searchKey, Resume r) {
        doSave(searchKey, r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey.toString());
    }

    @Override
    protected void doDelete(Object searchKey) {
        fillDeletedElement(searchKey);
    }

    @Override
    protected void insertElement(Object searchKey, Resume r) {
        map.put((String) searchKey, r);
    }

    @Override
    protected void fillDeletedElement(Object searchKey) {
        map.remove(searchKey.toString());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
