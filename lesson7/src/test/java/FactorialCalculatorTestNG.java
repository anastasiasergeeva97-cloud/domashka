package test.java;

import main.java.FactorialCalculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.*;

public class FactorialCalculatorTestNG {

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][] {
                {0, 1L},
                {1, 1L},
                {5, 120L},
                {10, 3628800L}
        };
    }

    @Test(groups = {"positive"})
    public void testFactorialPositiveNumbers() {
        assertEquals(FactorialCalculator.calculateFactorial(0), 1);
        assertEquals(FactorialCalculator.calculateFactorial(1), 1);
        assertEquals(FactorialCalculator.calculateFactorial(5), 120);
    }

    @test.java.Test(groups = {"negative"}, expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegativeNumber() {
        FactorialCalculator.calculateFactorial(-5);
    }

    @Test(groups = {"negative"}, expectedExceptions = IllegalArgumentException.class)
    public void testFactorialLargeNumber() {
        FactorialCalculator.calculateFactorial(21);
    }

    @Test(dataProvider = "factorialData", groups = {"parameterized"})
    public void testFactorialWithDataProvider(int input, long expected) {
        assertEquals(FactorialCalculator.calculateFactorial(input), expected);
    }
}
