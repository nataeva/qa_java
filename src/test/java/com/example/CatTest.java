package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.nio.file.FileAlreadyExistsException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline predator;
    @InjectMocks
    private Cat cat;

    @Test
    public void testGetSound() {
        String expectedSound = "Мяу";
        String resultSound = cat.getSound();

        assertEquals(expectedSound, resultSound);
    }

    @Test
    public void testGetFood() throws Exception {
        cat.getFood();

        verify(predator, times(1))
                .eatMeat();
    }
}