package com.java.exception;

public class TestException extends RuntimeException {
    private final String uuid;
    private final String dasmos;
    private final String color;
    private final String god;

    public TestException(String uuid, String dasmos, String color, String god) {
        this.uuid = uuid;
        this.dasmos = dasmos;
        this.color = color;
        this.god = god;
    }
    public TestException(String uuid, String dasmos, String color) {
        this(uuid, dasmos, color, "with no god");
    }
    public TestException(String uuid, String dasmos) {
        this(uuid, dasmos, "with no color");
    }
    public TestException(String uuid) {
        this(uuid, "with no dasmos");
    }
    public TestException() {
        this("with no uuid");
    }
}
