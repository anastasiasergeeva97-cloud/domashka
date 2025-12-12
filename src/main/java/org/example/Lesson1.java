package org.example;

public class Lesson1 {
    // 1. Метод printThreeWords()
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // 2. Метод checkSumSign()
    public static void checkSumSign() {
        int a = 5;
        int b = -3;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // 3. Метод printColor()
    public static void printColor() {
        int value = 75;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // 4. Метод compareNumbers()
    public static void compareNumbers() {
        int a = 7;
        int b = 12;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // 5. Метод для проверки суммы в диапазоне [10, 20]
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // 6. Метод для проверки положительное ли число
    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // 7. Метод для возврата true, если число отрицательное
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // 8. Метод для печати строки n раз
    public static void printStringMultipleTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    // 9. Метод для проверки високосного года
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // 10. Метод для инверсии массива из 0 и 1
    public static int[] invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }

    // 11. Метод для заполнения массива от 1 до 100
    public static int[] fillArray1To100() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    // 12. Метод для умножения чисел меньше 6 на 2
    public static int[] multiplyIfLessThan6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    // 13. Метод для заполнения диагоналей единицами
    public static int[][] fillDiagonals(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1; // Главная диагональ
            matrix[i][size - 1 - i] = 1; // Побочная диагональ
        }
        return matrix;
    }

    // 14. Метод для создания массива с одинаковыми значениями
    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    // Метод для печати массива
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Метод для печати двумерного массива
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Главный метод main для тестирования
    public static void main(String[] args) {
        System.out.println("=== Задание 1 ===");
        printThreeWords();

        System.out.println("\n=== Задание 2 ===");
        checkSumSign();

        System.out.println("\n=== Задание 3 ===");
        printColor();

        System.out.println("\n=== Задание 4 ===");
        compareNumbers();

        System.out.println("\n=== Задание 5 ===");
        System.out.println("Сумма 5 и 7 в диапазоне [10, 20]: " + isSumInRange(5, 7));
        System.out.println("Сумма 10 и 5 в диапазоне [10, 20]: " + isSumInRange(10, 5));

        System.out.println("\n=== Задание 6 ===");
        checkNumberSign(5);
        checkNumberSign(-3);
        checkNumberSign(0);

        System.out.println("\n=== Задание 7 ===");
        System.out.println("5 отрицательное? " + isNegative(5));
        System.out.println("-3 отрицательное? " + isNegative(-3));
        System.out.println("0 отрицательное? " + isNegative(0));

        System.out.println("\n=== Задание 8 ===");
        printStringMultipleTimes("Hello World!", 3);

        System.out.println("\n=== Задание 9 ===");
        System.out.println("2024 високосный? " + isLeapYear(2024));
        System.out.println("2023 високосный? " + isLeapYear(2023));
        System.out.println("1900 високосный? " + isLeapYear(1900));
        System.out.println("2000 високосный? " + isLeapYear(2000));

        System.out.println("\n=== Задание 10 ===");
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Исходный массив: ");
        printArray(array1);
        System.out.print("Инвертированный массив: ");
        printArray(invertArray(array1));

        System.out.println("\n=== Задание 11 ===");
        int[] array2 = fillArray1To100();
        System.out.print("Первые 10 элементов массива от 1 до 100: ");
        System.out.print("[");
        for (int i = 0; i < 10; i++) {
            System.out.print(array2[i]);
            if (i < 9) System.out.print(", ");
        }
        System.out.println("...]");

        System.out.println("\n=== Задание 12 ===");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Исходный массив: ");
        printArray(array3);
        System.out.print("После умножения чисел < 6 на 2: ");
        printArray(multiplyIfLessThan6(array3));

        System.out.println("\n=== Задание 13 ===");
        System.out.println("Матрица 5x5 с диагоналями:");
        printMatrix(fillDiagonals(5));

        System.out.println("\n=== Задание 14 ===");
        int[] array4 = createArray(5, 10);
        System.out.print("Массив из 5 элементов со значением 10: ");
        printArray(array4);
    }
}
