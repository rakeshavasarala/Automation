package com.rakesh.suite2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Simple4Test {

    @BeforeClass
    public void setUp() {
        System.out.println("SimpleTest 4 setup");
    }

/*    @BeforeMethod
    public void beforeMethodAll() {
      System.out.println("SimpleTest 1 beforeMethod for all methods");
    }

    @BeforeMethod(groups = {"fast"})
    public void beforeMethodFast() {
        System.out.println("SimpleTest 1 beforeMethod for fast group");
    }*/

    @Test(groups = { "fast" })
    public void aFastTest() {
        System.out.println("SimpleTest 4 Fast test");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("SimpleTest 4 Slow test");
    }

    @AfterClass
    public void end() {
        System.out.println("After SimpleTest 4");
    }

}
