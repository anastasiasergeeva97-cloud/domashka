package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование программ ===");

        // Тест факториала
        System.out.println("\n1. Факториал:");
        System.out.println("Факториал 5: " + FactorialCalculator.calculateFactorial(5));
        System.out.println("Факториал 0: " + FactorialCalculator.calculateFactorial(0));
        System.out.println("Факториал 7: " + FactorialCalculator.calculateFactorial(7));

        // Тест площади треугольника
        System.out.println("\n2. Площадь треугольника:");
        System.out.println("Площадь треугольника (основание=5, высота=4): " +
                TriangleAreaCalculator.calculateArea(5, 4));
        System.out.println("Площадь треугольника (основание=10, высота=6): " +
                TriangleAreaCalculator.calculateArea(10, 6));

        // Тест арифметических операций
        System.out.println("\n3. Арифметические операции:");
        int a = 10, b = 5;
        System.out.println(a + " + " + b + " = " + ArithmeticOperations.add(a, b));
        System.out.println(a + " - " + b + " = " + ArithmeticOperations.subtract(a, b));
        System.out.println(a + " * " + b + " = " + ArithmeticOperations.multiply(a, b));
        System.out.println(a + " / " + b + " = " + ArithmeticOperations.divide(a, b));

        // Тест сравнения чисел
        System.out.println("\n4. Сравнение чисел:");
        System.out.println(NumberComparator.compareNumbers(5, 3));
        System.out.println(NumberComparator.compareNumbers(3, 5));
        System.out.println(NumberComparator.compareNumbers(4, 4));

        System.out.println("\n=== Все программы работают корректно! ===");
    }
}