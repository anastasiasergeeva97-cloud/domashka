package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void testFactorialPositive() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
        assertEquals(720, FactorialCalculator.calculateFactorial(6));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "3, 6",
            "4, 24",
            "7, 5040",
            "8, 40320"
    })
    void testFactorialParameterized(int input, long expected) {
        assertEquals(expected, FactorialCalculator.calculateFactorial(input));
    }

    @Test
    void testFactorialNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.calculateFactorial(-1));
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.calculateFactorial(-10));
    }
}