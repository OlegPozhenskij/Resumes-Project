package com.java.model;

public enum ContactType {
    PHONE("Phone"),
    SKYPE("Skype"),
    MAIL("Mail"),
    LINKEDIN("Linked in"),
    GITHUB("GitHub"),
    STACKOVERFOLW("StackOverFlow"),
    HOMEPAGE("Home page");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "title='" + title + '\'' +
                '}';
    }
}
