package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    void testCompareNumbers() {
        assertEquals("5 больше 3", NumberComparator.compareNumbers(5, 3));
        assertEquals("3 меньше 5", NumberComparator.compareNumbers(3, 5));
        assertEquals("4 равно 4", NumberComparator.compareNumbers(4, 4));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, '10 больше 5'",
            "5, 10, '5 меньше 10'",
            "7, 7, '7 равно 7'",
            "-5, -10, '-5 больше -10'",
            "0, 0, '0 равно 0'",
            "-3, 5, '-3 меньше 5'",
            "100, 50, '100 больше 50'"
    })
    void testCompareNumbersParameterized(int a, int b, String expected) {
        assertEquals(expected, NumberComparator.compareNumbers(a, b));
    }

    @Test
    void testCompareNumbersEdgeCases() {
        assertEquals("0 больше -1", NumberComparator.compareNumbers(0, -1));
        assertEquals("2147483647 больше 0", NumberComparator.compareNumbers(Integer.MAX_VALUE, 0));
        assertEquals("-2147483648 меньше 0", NumberComparator.compareNumbers(Integer.MIN_VALUE, 0));
    }
}