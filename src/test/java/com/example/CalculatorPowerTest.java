package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorPowerTest {
    private final Calculator calc = new Calculator();

    @Test
    void powerWithPositiveExponent() {
        assertEquals(8, calc.power(2, 3)); // 2^3 = 8
        assertEquals(81, calc.power(3, 4)); // 3^4 = 81
        assertEquals(32, calc.power(2, 5)); // 2^5 = 32
    }

    @Test
    void powerWithZeroExponent() {
        assertEquals(1, calc.power(5, 0)); // 5^0 = 1
        assertEquals(1, calc.power(-10, 0)); // (-10)^0 = 1
        assertEquals(1, calc.power(0, 0)); // 0^0 = 1
    }

    @Test
    void powerWithZeroBaseAndPositiveExponent() {
        assertEquals(0, calc.power(0, 1)); // 0^1 = 0
        assertEquals(0, calc.power(0, 5)); // 0^5 = 0
    }

    @Test
    void powerWithOneBase() {
        assertEquals(1, calc.power(1, 0)); // 1^0 = 1
        assertEquals(1, calc.power(1, 10)); // 1^10 = 1
        assertEquals(1, calc.power(1, 1000)); // 1^1000 = 1
    }

    @Test
    void powerWithNegativeBaseAndEvenExponent() {
        assertEquals(16, calc.power(-2, 4)); // (-2)^4 = 16
        assertEquals(1, calc.power(-1, 2)); // (-1)^2 = 1
    }

    @Test
    void powerWithNegativeBaseAndOddExponent() {
        assertEquals(-8, calc.power(-2, 3)); // (-2)^3 = -8
        assertEquals(-1, calc.power(-1, 1)); // (-1)^1 = -1
    }

    @Test
    void powerWithNegativeExponentThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calc.power(2, -1));
        assertThrows(IllegalArgumentException.class, () -> calc.power(5, -5));
        assertThrows(IllegalArgumentException.class, () -> calc.power(0, -2));
    }

    @Test
    void powerWithLargePositiveValues() {
        assertEquals(65536, calc.power(2, 16)); // 2^16 = 65536
        // Test potential overflow if numbers were larger, but for int, this is fine.
        // int max_value / (base * base) ... to guard against it for very large bases/exponents
        // However, for standard int, the max value of power(int,int) will likely fit if base and exponent are small enough
    }
}