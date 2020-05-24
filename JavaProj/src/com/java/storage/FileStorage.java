package com.java.storage;

import com.java.exception.StorageException;
import com.java.model.Resume;
import com.java.storage.serializer.StreamSerializerStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    protected File directory;
    private StreamSerializerStrategy streamSerializerStrategy;

    protected FileStorage(File directory, StreamSerializerStrategy streamSerializerStrategy) {
        Objects.requireNonNull(directory, "directory mast not be null");
        this.streamSerializerStrategy = streamSerializerStrategy;
        if(!directory.isDirectory())
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory!");
        if(!directory.canRead() || !directory.canWrite())
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable!");

        this.directory = directory;
    }

    @Override
    protected void doSave(File file, Resume r) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(file, r);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(File file, Resume r) {
        try {
            streamSerializerStrategy.doWrite(new BufferedOutputStream(new FileOutputStream(file)), r);
        } catch (IOException e) {
            throw new StorageException(r.getUuid(), "File write error", e);
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return streamSerializerStrategy.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Couldn't read file " + file.getAbsolutePath(), file.getName(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if(!file.delete()) {
            throw new StorageException("File delete error", file.getName());
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        List<Resume> list = new ArrayList<>(Collections.emptyList());
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory read error");
        }
        for (File f : files) {
            list.add(doGet(f));
        }
        return list;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if(files != null) {
            for (File f : files) {
                doDelete(f);
            }
        }
    }

    @Override
    public int size() {
        String[] s = directory.list();
        if(s != null)
            return s.length;
        throw new StorageException(null, "Directory read error");
    }
}
