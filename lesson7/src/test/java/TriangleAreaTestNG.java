package test.java;

import main.java.TriangleArea;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.*;

public class TriangleAreaTestNG {

    @DataProvider(name = "areaData")
    public Object[][] areaData() {
        return new Object[][] {
                {10.0, 5.0, 25.0},
                {4.0, 6.0, 12.0},
                {7.0, 3.0, 10.5}
        };
    }

    @Test
    public void testCalculateArea() {
        assertEquals(TriangleArea.calculateArea(10, 5), 25.0);
        assertEquals(TriangleArea.calculateArea(3, 5), 7.5, 0.001);
    }

    @Test
    public void testCalculateAreaHeron() {
        assertEquals(TriangleArea.calculateAreaHeron(3, 4, 5), 6.0, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeSides() {
        TriangleArea.calculateArea(-5, 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangle() {
        TriangleArea.calculateAreaHeron(1, 2, 10);
    }

    @Test(dataProvider = "areaData")
    public void testAreaWithDataProvider(double base, double height, double expected) {
        assertEquals(TriangleArea.calculateArea(base, height), expected, 0.001);
    }
}