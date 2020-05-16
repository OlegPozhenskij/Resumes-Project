package com.java.model;

public class Link {
    private String rel;
    private String type;
    private String title;

    public Link(String rel, String type, String title) {
        this.rel = rel;
        this.type = type;
        this.title = title;
    }

    public String getrel() {
        return rel;
    }

    public void setrel(String rel) {
        this.rel = rel;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Link{" +
                "rel='" + rel + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
