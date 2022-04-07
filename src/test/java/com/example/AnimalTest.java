package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {
    private String animalKind;
    private List<String> expectedFood;

    public AnimalTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters(name = "Тестовые данные: тип животного - {0}, ожидаемая еда - {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void testGetFoodHappyCases() throws Exception {
        List<String> resultFood = new Animal().getFood(animalKind);

        assertEquals("Food items should be equal!", expectedFood, resultFood);
    }

    @Test
    public void testGetFoodOtherAnimal() {
        assertThrows("Exception should have been thrown!",
                Exception.class,
                () -> new Animal().getFood("some animal"));
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();

        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        String resultFamily = animal.getFamily();

        assertEquals("getFamily should return + '" + expectedFamily + "'!",
                expectedFamily,
                resultFamily);
    }
}