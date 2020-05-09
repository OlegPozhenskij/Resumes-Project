package com.java;

import com.java.model.Resume;

import java.util.*;

public class MainCollection {

    private static final String UUID_1 = "uuid_1";
    private static final Resume R1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid_2";
    private static final Resume R2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid_3";
    private static final Resume R3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid_4";
    private static final Resume R4 = new Resume(UUID_4);

    public static void main(String[] args) {
        MainCollection mc = new MainCollection();
        ArrayList al = new ArrayList();
        al.add("First element");
        al.add("Second element");
        al.add("Third element");
        Iterator it = al.iterator();
        while(it.hasNext()) {
            System.out.println((String)it.next());
        }
        System.out.println("\n");
        al.add(2,"Insertion");
        it = al.iterator();
        while(it.hasNext()){
            System.out.println((String)it.next());
        }


    }
}



