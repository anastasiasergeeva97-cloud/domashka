package main.java;
public class FactorialCalculator {

    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Число слишком большое для типа long");
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Факториал 5: " + calculateFactorial(5));
        System.out.println("Факториал 0: " + calculateFactorial(0));
    }
}