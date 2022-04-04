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

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testHasManeHappyCases() throws Exception {
        Lion lion = new Lion(sex);

        boolean resultHasMane = lion.doesHaveMane();

        assertEquals("Males should have mane, females should not!",
                expectedHasMane,
                resultHasMane);
    }

    @Test
    public void testHasManeOtherSex() {
        assertThrows("Should have thrown an exception!",
                Exception.class,
                () -> new Lion("Other sex"));
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = Mockito.spy(new Lion("Самец"));

        lion.getFood();

        verify(lion, times(1)).getFood("Хищник");
    }
}