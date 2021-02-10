package com.example;

import org.testng.annotations.*;

public class SimpleTest {


    @BeforeClass (groups = "include")public void setup() {
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(name);
    }

    @Test (groups = "include")
    public void test() {
        System.out.println("test is starting");
    }

    @AfterClass (groups = "include") public void teardown() {
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(name);
    }
}
