package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    private int a;
    private int b;

    @BeforeEach
    void setUp() {
        a = 10;
        b = 5;
    }

    @Test
    void testAdd() {
        assertEquals(15, ArithmeticOperations.add(a, b));
        assertEquals(15, ArithmeticOperations.add(b, a));
        assertEquals(-3, ArithmeticOperations.add(2, -5));
        assertEquals(0, ArithmeticOperations.add(0, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(5, ArithmeticOperations.subtract(a, b));
        assertEquals(-5, ArithmeticOperations.subtract(b, a));
        assertEquals(0, ArithmeticOperations.subtract(5, 5));
        assertEquals(10, ArithmeticOperations.subtract(5, -5));
    }

    @Test
    void testMultiply() {
        assertEquals(50, ArithmeticOperations.multiply(a, b));
        assertEquals(0, ArithmeticOperations.multiply(0, a));
        assertEquals(-15, ArithmeticOperations.multiply(3, -5));
        assertEquals(25, ArithmeticOperations.multiply(-5, -5));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 2.0",
            "5, 2, 2.5",
            "9, 3, 3.0",
            "1, 4, 0.25"
    })
    void testDivideValid(int dividend, int divisor, double expected) {
        assertEquals(expected, ArithmeticOperations.divide(dividend, divisor), 0.001);
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class,
                () -> ArithmeticOperations.divide(a, 0));
        assertThrows(ArithmeticException.class,
                () -> ArithmeticOperations.divide(100, 0));
    }
}