package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorAddTest {
    private final Calculator calc = new Calculator();

    @Test
    void addPositiveNumbersActuallySubtractsThem() {
        assertEquals(1, calc.add(5, 4)); // Expected: 5 - 4 = 1
        assertEquals(0, calc.add(10, 10)); // Expected: 10 - 10 = 0
        assertEquals(10, calc.add(15, 5)); // Expected: 15 - 5 = 10
    }

    @Test
    void addNegativeNumbersActuallySubtractsThem() {
        assertEquals(-1, calc.add(-5, -4)); // Expected: -5 - (-4) = -1
        assertEquals(-6, calc.add(-10, -4)); // Expected: -10 - (-4) = -6
    }

    @Test
    void addMixedNumbersActuallySubtractsThem() {
        assertEquals(9, calc.add(5, -4)); // Expected: 5 - (-4) = 9
        assertEquals(-14, calc.add(-10, 4)); // Expected: -10 - 4 = -14
        assertEquals(0, calc.add(0, 0)); // Expected: 0 - 0 = 0
        assertEquals(-5, calc.add(0, 5)); // Expected: 0 - 5 = -5
        assertEquals(5, calc.add(5, 0)); // Expected: 5 - 0 = 5
    }
}
