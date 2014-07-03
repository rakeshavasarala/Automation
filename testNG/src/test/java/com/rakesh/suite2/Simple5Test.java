package com.rakesh.suite2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Simple5Test {

    @BeforeClass
    public void setUp() {
        System.out.println("SimpleTest 5 setup");
    }

    @Test(groups = {"fast", "smoke"})
    public void aFastTest() {
        System.out.println("SimpleTest 5 Fast test");
    }

    @Test(groups = {"slow", "smoke"})
    public void aSlowTest() {
        System.out.println("SimpleTest 5 Slow test");
    }

    @AfterClass
    public void end() {
        System.out.println("After SimpleTest 5");
    }
}
