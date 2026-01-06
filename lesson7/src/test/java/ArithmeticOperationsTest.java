package test.java;

import main.java.ArithmeticOperations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    @DisplayName("Проверка сложения")
    void testAdd() {
        assertEquals(15, ArithmeticOperations.add(10, 5));
        assertEquals(-5, ArithmeticOperations.add(-10, 5));
        assertEquals(0, ArithmeticOperations.add(0, 0));
    }

    @Test
    @DisplayName("Проверка вычитания")
    void testSubtract() {
        assertEquals(5, ArithmeticOperations.subtract(10, 5));
        assertEquals(-15, ArithmeticOperations.subtract(-10, 5));
    }

    @Test
    @DisplayName("Проверка умножения")
    void testMultiply() {
        assertEquals(50, ArithmeticOperations.multiply(10, 5));
        assertEquals(-50, ArithmeticOperations.multiply(-10, 5));
        assertEquals(0, ArithmeticOperations.multiply(0, 5));
    }

    @Test
    @DisplayName("Проверка деления")
    void testDivide() {
        assertEquals(2.0, ArithmeticOperations.divide(10, 5), 0.001);
        assertEquals(-2.0, ArithmeticOperations.divide(-10, 5), 0.001);
        assertEquals(2.5, ArithmeticOperations.divide(5, 2), 0.001);
    }

    @Test
    @DisplayName("Проверка деления на ноль")
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> ArithmeticOperations.divide(10, 0)
        );
        assertEquals("Деление на ноль невозможно", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 15",
            "-3, 7, 4",
            "0, 0, 0"
    })
    @DisplayName("Параметризованный тест сложения")
    void testAddParameterized(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.add(a, b));
    }
}