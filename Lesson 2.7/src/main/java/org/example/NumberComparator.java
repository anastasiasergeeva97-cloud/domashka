package org.example;

public class NumberComparator {
    public static String compareNumbers(int a, int b) {
        if (a > b) {
            return a + " больше " + b;
        } else if (a < b) {
            return a + " меньше " + b;
        } else {
            return a + " равно " + b;
        }
    }
}