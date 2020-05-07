package com.java;

import com.java.model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume resume = new Resume();
        Method method = resume.getClass().getDeclaredMethod("toString");
        System.out.println(method.invoke(resume));
    }
}
