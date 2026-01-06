package test.java;

import main.java.NumberComparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    @DisplayName("Проверка сравнения чисел")
    void testCompare() {
        assertEquals("5 больше 3", NumberComparator.compare(5, 3));
        assertEquals("2 меньше 7", NumberComparator.compare(2, 7));
        assertEquals("4 равно 4", NumberComparator.compare(4, 4));
    }

    @Test
    @DisplayName("Проверка нахождения максимума")
    void testGetMax() {
        assertEquals(10, NumberComparator.getMax(10, 5));
        assertEquals(7, NumberComparator.getMax(-3, 7));
        assertEquals(5, NumberComparator.getMax(5, 5));
    }

    @Test
    @DisplayName("Проверка нахождения минимума")
    void testGetMin() {
        assertEquals(5, NumberComparator.getMin(10, 5));
        assertEquals(-3, NumberComparator.getMin(-3, 7));
        assertEquals(5, NumberComparator.getMin(5, 5));
    }

    @Test
    @DisplayName("Проверка равенства чисел")
    void testAreEqual() {
        assertTrue(NumberComparator.areEqual(5, 5));
        assertFalse(NumberComparator.areEqual(5, 3));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, '5 больше 3'",
            "3, 5, '3 меньше 5'",
            "4, 4, '4 равно 4'"
    })
    @DisplayName("Параметризованный тест сравнения")
    void testCompareParameterized(int a, int b, String expected) {
        assertEquals(expected, NumberComparator.compare(a, b));
    }
}