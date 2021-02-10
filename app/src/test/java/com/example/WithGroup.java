package com.example;

import org.testng.annotations.*;


public class WithGroup {

    @BeforeClass(groups = "include")
    public void setup() {
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println(name);
    }

    @Test(groups = "include", priority = 3)
    @Parameters({"par1", "par2"})
    public void firstCase(String par1, String par2) {

        System.out.println("First test case execution using provided parameters: " + par1 + " + " + par2);
    }

    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][]{
                {1, 11},
                {2, 2}
        };
    }

    @Test(groups = "functional testing", priority = 2, dataProvider = "data")
    public void secondCase(int a, int b) {
        System.out.println("Second test case  execution using dataprovider: " + a + b);
    }


    @Test(groups = "include", priority = 1,dependsOnGroups = "functional testing")
    public void thirdCase() {
        System.out.println("Third test case execution with P1 will be run after Group dependency executed ^");
    }

    @Test(groups = "exclude")
    public void forthCase() {
        System.out.println("Forth case SHOULD NOT be executed");
    }

    @AfterClass(groups = "include")
    public void teardown() {
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println(name);
    }
}