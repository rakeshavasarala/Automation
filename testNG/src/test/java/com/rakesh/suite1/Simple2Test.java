package com.rakesh.suite1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Simple2Test {

    @BeforeClass
    public void setUp() {
        System.out.println("SimpleTest 2 setup");
    }

    @Test(groups = {"fast", "smoke"})
    public void aFastTest() {
        System.out.println("SimpleTest 2 Fast test");
    }

    @Test(groups = {"slow", "smoke"})
    public void aSlowTest() {
        System.out.println("SimpleTest 2 Slow test");
    }

    @AfterClass
    public void end() {
        System.out.println("After SimpleTest 2");
    }
}
