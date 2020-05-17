package com.java.main;

import com.java.model.ContactType;
import com.java.model.SectionType;

public class TestSingleton {
    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton.valueOf("INSTANCE");
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }

        System.out.println("---------------------");

        for (ContactType type : ContactType.values()) {
            System.out.println(type.getTitle());
        }
    }

    public enum Singleton {
        INSTANCE
    }
}
