package com.java.storage;

import com.java.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doSave(Object resume, Resume r) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected void doUpdate(Object resume, Resume r) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(Object resume) {
        map.remove(((Resume) resume).getUuid());
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
