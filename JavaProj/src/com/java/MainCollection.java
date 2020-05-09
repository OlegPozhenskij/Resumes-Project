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
//        Collection<Resume> collection = new ArrayList<>();
//
//        collection.add(R1);
//        collection.add(R2);
//        collection.add(R3);

//        for (Resume r: collection) {
//            if(Objects.equals(r.getUuid(), UUID_1)) {        not work!!!
//                collection.remove(r);
//            }
//        }
//        System.out.println(collection.toString());
//
//
//        Iterator<Resume> iter = collection.iterator();
//        while (iter.hasNext()) {
//            Resume r = iter.next();
//            if(Objects.equals(r, UUID_1)) {
//                iter.remove();
//            }
//        }

        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, R1);
        map.put(UUID_2, R2);
        map.put(UUID_3, R3);
        map.put(UUID_4, R4);


        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
