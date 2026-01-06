package test.java;
import main.java.TriangleArea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    @Test
    @DisplayName("Проверка площади по основанию и высоте")
    void testCalculateArea() {
        assertEquals(25.0, TriangleArea.calculateArea(10, 5));
        assertEquals(7.5, TriangleArea.calculateArea(3, 5));
    }

    @Test
    @DisplayName("Проверка площади по формуле Герона")
    void testCalculateAreaHeron() {
        assertEquals(6.0, TriangleArea.calculateAreaHeron(3, 4, 5), 0.001);
        assertEquals(14.6969, TriangleArea.calculateAreaHeron(7, 8, 5), 0.001);
    }

    @Test
    @DisplayName("Проверка исключения для отрицательных сторон")
    void testNegativeSides() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.calculateArea(-5, 10));
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.calculateAreaHeron(-3, 4, 5));
    }

    @Test
    @DisplayName("Проверка несуществующего треугольника")
    void testInvalidTriangle() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.calculateAreaHeron(1, 2, 10));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 25.0",
            "4, 6, 12.0",
            "7, 3, 10.5"
    })
    @DisplayName("Параметризованный тест площади треугольника")
    void testAreaParameterized(double base, double height, double expected) {
        assertEquals(expected, TriangleArea.calculateArea(base, height), 0.001);
    }
}