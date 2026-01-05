package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTest {

    @Test
    void testCalculateAreaValid() {
        assertEquals(10.0, TriangleAreaCalculator.calculateArea(5, 4), 0.001);
        assertEquals(30.0, TriangleAreaCalculator.calculateArea(10, 6), 0.001);
        assertEquals(6.0, TriangleAreaCalculator.calculateArea(3, 4), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "5.0, 4.0, 10.0",
            "10.0, 6.0, 30.0",
            "3.0, 4.0, 6.0",
            "7.5, 2.0, 7.5"
    })
    void testCalculateAreaParameterized(double base, double height, double expected) {
        double result = TriangleAreaCalculator.calculateArea(base, height);
        assertEquals(expected, result, 0.001);
    }

    @Test
    void testCalculateAreaInvalidThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(-5, 4));
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(5, -4));
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(0, 4));
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(5, 0));
    }
}
