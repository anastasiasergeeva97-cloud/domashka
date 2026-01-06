package test.java;

import main.java.NumberComparator;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.*;

public class NumberComparatorTestNG {

    @DataProvider(name = "comparisonData")
    public Object[][] comparisonData() {
        return new Object[][] {
                {5, 3, "5 больше 3"},
                {3, 5, "3 меньше 5"},
                {4, 4, "4 равно 4"}
        };
    }

    @Test
    public void testCompare() {
        assertEquals(NumberComparator.compare(5, 3), "5 больше 3");
        assertEquals(NumberComparator.compare(2, 7), "2 меньше 7");
        assertEquals(NumberComparator.compare(4, 4), "4 равно 4");
    }

    @Test
    public void testGetMax() {
        assertEquals(NumberComparator.getMax(10, 5), 10);
        assertEquals(NumberComparator.getMax(-3, 7), 7);
    }

    @Test
    public void testGetMin() {
        assertEquals(NumberComparator.getMin(10, 5), 5);
        assertEquals(NumberComparator.getMin(-3, 7), -3);
    }

    @Test
    public void testAreEqual() {
        assertTrue(NumberComparator.areEqual(5, 5));
        assertFalse(NumberComparator.areEqual(5, 3));
    }

    @Test(dataProvider = "comparisonData")
    public void testCompareWithDataProvider(int a, int b, String expected) {
        assertEquals(NumberComparator.compare(a, b), expected);
    }
}