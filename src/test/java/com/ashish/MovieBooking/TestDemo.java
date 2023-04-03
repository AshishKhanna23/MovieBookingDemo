package com.ashish.MovieBooking;

import org.junit.jupiter.api.*;

public class TestDemo {

    @Test
    public void myFirstTest(){
        System.out.println("Inside First Test");
    }

    @Test
    public void mySecondTest(){
        System.out.println("Inside Second Test");
    }

    @BeforeEach
    public void BeforeEachTest(){
        System.out.println("Before Each Test");
    }

    @AfterEach
    public void AfterEachTest(){
        System.out.println("After Each Test");
    }

    @BeforeAll
    public static void VeryBeginning(){
        System.out.println("In the very Beginning");
    }

    @AfterAll
    public static void lastMethod(){
        System.out.println("In the Very Last");
    }
}
