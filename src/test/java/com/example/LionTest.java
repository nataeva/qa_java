package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(Parameterized.class)
public class LionTest {

    private String sex;
    private boolean expectedHasMane;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Тестовые данные: пол льва - {0}, должен иметь гриву - {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testHasManeHappyCases() throws Exception {
        Lion lion = new Lion(sex, new Feline());

        boolean resultHasMane = lion.doesHaveMane();

        assertEquals("Males should have mane, females should not!",
                expectedHasMane,
                resultHasMane);
    }

    @Test
    public void testHasManeOtherSex() {
        assertThrows("Should have thrown an exception!",
                Exception.class,
                () -> new Lion("Other sex", new Feline()));
    }

    @Test
    public void testGetFood() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = Mockito.spy(new Lion("Самец", mockFeline));

        lion.getFood();

        verify(mockFeline, times(1)).getFood("Хищник");
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = Mockito.spy(new Lion("Самец", mockFeline));

        lion.getKittens();

        verify(mockFeline, times(1)).getKittens();
    }
}