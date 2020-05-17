package com.java.main;

import java.io.*;

public class MainFile {
    private static final String FILE_NAME = "/home/oleg/Видео/Projects/Resumes-Project/JavaProj";
    private static final File F = new File(FILE_NAME);

    public static void main(String[] args) {
//        goResursion(F, "");
//        System.out.println(F.getAbsolutePath());
    }

    private static void goResursion(File file, String offset) {
        File[] files = file.listFiles();

        if(files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(offset + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println(offset + f.getName());
                    goResursion(f, offset + "  ");
                }
            }
        }
    }
}
