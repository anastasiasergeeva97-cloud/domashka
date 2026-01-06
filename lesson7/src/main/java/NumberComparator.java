package main.java;

public class NumberComparator {

    public static String compare(int a, int b) {
        if (a > b) {
            return a + " больше " + b;
        } else if (a < b) {
            return a + " меньше " + b;
        } else {
            return a + " равно " + b;
        }
    }

    public static int getMax(int a, int b) {
        return Math.max(a, b);
    }

    public static int getMin(int a, int b) {
        return Math.min(a, b);
    }

    public static boolean areEqual(int a, int b) {
        return a == b;
    }

    public static void main(String[] args) {
        System.out.println("Сравнение 5 и 3: " + compare(5, 3));
        System.out.println("Сравнение 2 и 7: " + compare(2, 7));
        System.out.println("Сравнение 4 и 4: " + compare(4, 4));
    }
}