package com.java.model;

import com.java.storage.Storage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListSection extends Section {
    private List<String> items = new ArrayList<>();

    public ListSection(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "items=" + items +
                '}';
    }
}
