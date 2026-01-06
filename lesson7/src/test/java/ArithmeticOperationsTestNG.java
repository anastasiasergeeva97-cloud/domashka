package test.java;

import main.java.ArithmeticOperations;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.*;

public class ArithmeticOperationsTestNG {

    public Object[][] arithmeticData() {
        return new Object[][] {
                {10, 5, 15, 5, 50, 2.0},
                {-3, 7, 4, -10, -21, -0.428}
        };
    }

    @Test
    public void testAdd() {
        assertEquals(ArithmeticOperations.add(10, 5), 15);
        assertEquals(ArithmeticOperations.add(-10, 5), -5);
    }

    @Test
    public void testSubtract() {
        assertEquals(ArithmeticOperations.subtract(10, 5), 5);
    }

    @Test
    public void testMultiply() {
        assertEquals(ArithmeticOperations.multiply(10, 5), 50);
    }

    @Test
    public void testDivide() {
        assertEquals(ArithmeticOperations.divide(10, 5), 2.0, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(10, 0);
    }

    @Test(dataProvider = "arithmeticData")
    public void testAllOperations(int a, int b, int sum, int diff, int product, double quotient) {
        assertEquals(ArithmeticOperations.add(a, b), sum);
        assertEquals(ArithmeticOperations.subtract(a, b), diff);
        assertEquals(ArithmeticOperations.multiply(a, b), product);
        assertEquals(ArithmeticOperations.divide(a, b), quotient, 0.001);
    }
}