package com.java.storage;

import com.java.model.Resume;

import java.io.File;
import java.util.List;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    protected final static String PATH = "/home/oleg/New/asd.txt";
    protected File file = new File(PATH);

    @Override
    protected void doSave(File searchKey, Resume r) {

    }

    @Override
    protected boolean isExist(File searchKey) {
        return false;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected void doUpdate(File searchKey, Resume r) {

    }

    @Override
    protected Resume doGet(File searchKey) {
        return null;
    }

    @Override
    protected void doDelete(File searchKey) {

    }

    @Override
    protected List<Resume> doCopyAll() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
