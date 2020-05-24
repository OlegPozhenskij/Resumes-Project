package com.java.model;

import com.java.storage.Storage;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class ListSection extends Section {
    private static final long serialVersionUID = 1L;

    private final List<String> items;

    public ListSection(String ... items) {
        Objects.requireNonNull(items, "Items mast not be null");
        this.items = Arrays.asList(items);
    }

    public ListSection(List<String> items) {
        Objects.requireNonNull(items, "Items mast not be null");
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "items=" + items +
                '}';
    }
}
