package com.java.main;

import com.java.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

public class TestReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Resume resume = new Resume(UUID.randomUUID().toString(), "name1");
        Method method = resume.getClass().getDeclaredMethod("toString");
        System.out.println(method.invoke(resume));

        Class myClass1 = resume.getClass(); // we get class of Resume
        Class myClass2 = Class.forName("com.java.model.Resume");

        System.out.println(myClass1.getSimpleName());
        System.out.println(myClass1.getName());

        Field[] fields = myClass1.getFields();

        for (Field f : fields) {
            System.out.println(f.getName());//only public
        }
    }
}
