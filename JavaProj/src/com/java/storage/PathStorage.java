package com.java.storage;

import com.java.exception.StorageException;
import com.java.model.Resume;
import com.java.storage.serializer.StreamSerializerStrategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PathStorage extends AbstractStorage<Path> {
    protected Path directory;
    private StreamSerializerStrategy streamSerializerStrategy;

    protected PathStorage(String dir, StreamSerializerStrategy streamSerializerStrategy) {
        directory = Paths.get(dir);
        this.streamSerializerStrategy = streamSerializerStrategy;
        Objects.requireNonNull(directory, "directory mast not be null");
        if(!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "is not directory or is not writeable");
        }
    }

    @Override
    protected void doSave(Path path, Resume r) {
        try {
            doUpdate(Files.createFile(path), r);
        } catch (IOException e) {
            throw new StorageException("Couldn't create Path " + path, path.getFileName().toString(), e);
        }
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.isRegularFile(path);
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected void doUpdate(Path path, Resume r) {
        try {
            streamSerializerStrategy.doWrite(new BufferedOutputStream(Files.newOutputStream(path, StandardOpenOption.WRITE)), r);
        } catch (IOException e) {
            throw new StorageException(r.getUuid(), "Path write error", e);
        }
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return streamSerializerStrategy.doRead(new BufferedInputStream(Files.newInputStream(path, StandardOpenOption.READ)));
        } catch (IOException e) {
            throw new StorageException("Couldn't read Path", e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Path delete error", e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        return getFilesList().map(path -> doGet(path)).collect(Collectors.toList());
    }

    @Override
    public void clear() {
        getFilesList().forEach(path -> doDelete(path));
    }

    private Stream<Path> getFilesList()  {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("Directory read error", e);
        }
    }

    @Override
    public int size() {
        return (int) getFilesList().count();
    }
}
