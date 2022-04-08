package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {

        feline.eatMeat();

        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        String expected = "Кошачьи";

        String actual = feline.getFamily();

        assertEquals("Family should be '" + expected + "'!",
        expected, 
        actual);
    }

    @Test
    public void testGetKittensWithParam() {
        int expected = 9;

        int actual = feline.getKittens(9);

        assertEquals("getKittens should return " + expected + "!", 
        expected, 
        actual);
    }

    @Test
    public void testGetKittensWithoutParam() {
        int expected = 1;

        int actual = feline.getKittens();

        assertEquals("getKittens without param should return 1!", 
        expected, 
        actual);
    }
}