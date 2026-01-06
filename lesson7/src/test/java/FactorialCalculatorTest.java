package test.java;

import main.java.FactorialCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    @DisplayName("Проверка факториала положительных чисел")
    void testFactorialPositiveNumbers() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
        assertEquals(2, FactorialCalculator.calculateFactorial(2));
        assertEquals(6, FactorialCalculator.calculateFactorial(3));
        assertEquals(24, FactorialCalculator.calculateFactorial(4));
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }

    @Test
    @DisplayName("Проверка исключения для отрицательных чисел")
    void testFactorialNegativeNumber() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> FactorialCalculator.calculateFactorial(-5)
        );
        assertEquals("Факториал отрицательного числа не определен", exception.getMessage());
    }

    @Test
    @DisplayName("Проверка исключения для больших чисел")
    void testFactorialLargeNumber() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> FactorialCalculator.calculateFactorial(21)
        );
        assertEquals("Число слишком большое для типа long", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120",
            "10, 3628800"
    })
    @DisplayName("Параметризованный тест факториала")
    void testFactorialParameterized(int input, long expected) {
        assertEquals(expected, FactorialCalculator.calculateFactorial(input));
    }
}