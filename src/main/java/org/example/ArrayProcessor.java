package org.example;

// =========== ЧАСТЬ 1: СОЗДАЕМ КЛАССЫ ИСКЛЮЧЕНИЙ ===========

// 1.1. Класс для исключения "Неправильный размер массива"
class MyArraySizeException extends Exception {
    // Конструктор - вызывается когда создаем новое исключение
    public MyArraySizeException(String message) {
        // Передаем сообщение родительскому классу Exception
        super(message);
        // Теперь при вызове e.getMessage() получим наше сообщение
    }
}

// 1.2. Класс для исключения "Неправильные данные в ячейке"
class MyArrayDataException extends Exception {
    // Добавляем поля для хранения координат ячейки
    private final int row;    // номер строки
    private final int col;    // номер столбца

    // Конструктор
    public MyArrayDataException(String message, int row, int col) {
        super(message);  // передаем сообщение родителю
        this.row = row;  // сохраняем строку
        this.col = col;  // сохраняем столбец
    }

    // Геттеры - методы для получения значений полей
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

// =========== ЧАСТЬ 2: СОЗДАЕМ ГЛАВНЫЙ КЛАСС ===========

public class ArrayProcessor {

    // =========== ЧАСТЬ 2.1: МЕТОД ДЛЯ ОБРАБОТКИ МАССИВА ===========
    /**
     * Метод обрабатывает двумерный массив строк
     * @param array - двумерный массив 4х4 со строками
     * @return сумму всех элементов, преобразованных в числа
     * @throws MyArraySizeException если массив не 4х4
     * @throws MyArrayDataException если в ячейке не число
     */
    public static int processArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        System.out.println("\n=== Начинаем обработку массива ===");

        // ----- ПРОВЕРКА РАЗМЕРА МАССИВА -----
        // 1. Проверяем количество строк
        if (array.length != 4) {
            throw new MyArraySizeException(
                    " ОШИБКА РАЗМЕРА! Нужно 4 строки, а у вас: " + array.length
            );
        }

        // 2. Проверяем количество столбцов в каждой строке
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        String.format(" ОШИБКА РАЗМЕРА! В строке %d нужно 4 столбца, а у вас: %d",
                                i, array[i].length)
                );
            }
        }

        System.out.println("✓ Размер массива правильный (4x4)");

        // ----- СУММИРОВАНИЕ ЭЛЕМЕНТОВ -----
        int sum = 0;  // переменная для хранения суммы

        // Внешний цикл по строкам (i - номер строки)
        for (int i = 0; i < array.length; i++) {
            // Внутренний цикл по столбцам (j - номер столбца)
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Пытаемся преобразовать строку в число
                    // Например: "123" → 123
                    int number = Integer.parseInt(array[i][j]);

                    // Добавляем к сумме
                    sum += number;

                    System.out.printf("  Ячейка [%d][%d] = '%s' → число %d, текущая сумма: %d%n",
                            i, j, array[i][j], number, sum);

                } catch (NumberFormatException e) {
                    // Если не получилось преобразовать (например, там "abc")
                    throw new MyArrayDataException(
                            String.format(" НЕВЕРНЫЕ ДАННЫЕ! В ячейке [%d][%d] лежит '%s', а должно быть число",
                                    i, j, array[i][j]),
                            i, j
                    );
                }
            }
        }

        System.out.println("✓ Все ячейки обработаны успешно!");
        return sum;
    }

    // =========== ЧАСТЬ 2.2: МЕТОД ДЛЯ ВЫВОДА МАССИВА НА ЭКРАН ===========
    /**
     * Вспомогательный метод для красивого вывода массива
     */
    public static void printArray(String[][] array, String name) {
        System.out.println("\n Массив '" + name + "':");
        for (int i = 0; i < array.length; i++) {
            System.out.print("  ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // =========== ЧАСТЬ 3: ГЛАВНЫЙ МЕТОД PROGRAM ===========
    public static void main(String[] args) {

        System.out.println("========== ПРОГРАММА ОБРАБОТКИ МАССИВОВ ==========");

        // ----- ТЕСТ 1: КОРРЕКТНЫЙ МАССИВ -----
        System.out.println("\n\n ТЕСТ 1: Корректный массив 4x4");

        String[][] correctArray = {
                {"1", "2", "3", "4"},     // строка 0
                {"5", "6", "7", "8"},     // строка 1
                {"9", "10", "11", "12"},  // строка 2
                {"13", "14", "15", "16"}  // строка 3
        };

        printArray(correctArray, "correctArray");

        try {
            int result = processArray(correctArray);
            System.out.println("\n РЕЗУЛЬТАТ: Сумма всех чисел = " + result);
        } catch (MyArraySizeException e) {
            System.out.println(" Поймано исключение MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(" Поймано исключение MyArrayDataException: " + e.getMessage());
            System.out.println("   Координаты ошибки: строка " + e.getRow() + ", столбец " + e.getCol());
        }

        // ----- ТЕСТ 2: МАССИВ С ОШИБКОЙ В ДАННЫХ -----
        System.out.println("\n\n ТЕСТ 2: Массив с ошибкой в данных");

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "десять", "11", "12"},  // ОШИБКА: "десять" вместо числа
                {"13", "14", "15", "16"}
        };

        printArray(wrongDataArray, "wrongDataArray");

        try {
            int result = processArray(wrongDataArray);
            System.out.println("\n РЕЗУЛЬТАТ: Сумма всех чисел = " + result);
        } catch (MyArraySizeException e) {
            System.out.println(" Поймано исключение MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(" Поймано исключение MyArrayDataException: " + e.getMessage());
            System.out.println("   Координаты ошибки: строка " + e.getRow() + ", столбец " + e.getCol());
        }

        // ----- ТЕСТ 3: МАССИВ НЕПРАВИЛЬНОГО РАЗМЕРА -----
        System.out.println("\n\n ТЕСТ 3: Массив неправильного размера (3x3)");

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        printArray(wrongSizeArray, "wrongSizeArray");

        try {
            int result = processArray(wrongSizeArray);
            System.out.println("\n РЕЗУЛЬТАТ: Сумма всех чисел = " + result);
        } catch (MyArraySizeException e) {
            System.out.println(" Поймано исключение MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(" Поймано исключение MyArrayDataException: " + e.getMessage());
            System.out.println("   Координаты ошибки: строка " + e.getRow() + ", столбец " + e.getCol());
        }

        // ----- ТЕСТ 4: ГЕНЕРАЦИЯ ArrayIndexOutOfBoundsException -----
        System.out.println("\n\n ТЕСТ 4: Демонстрация ArrayIndexOutOfBoundsException");

        try {
            System.out.println("Создаем массив из 3 элементов...");
            int[] smallArray = new int[3];  // массив с индексами 0, 1, 2

            System.out.println("Заполняем массив:");
            smallArray[0] = 10;
            smallArray[1] = 20;
            smallArray[2] = 30;

            System.out.println("Массив: [" + smallArray[0] + ", " +
                    smallArray[1] + ", " +
                    smallArray[2] + "]");

            // ПЫТАЕМСЯ ОБРАТИТЬСЯ К НЕСУЩЕСТВУЮЩЕМУ ЭЛЕМЕНТУ
            System.out.println("\nПытаемся получить элемент с индексом 5...");
            int value = smallArray[5];  // ОШИБКА! Такого индекса нет

            System.out.println("Значение: " + value);  // эта строка не выполнится

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" Поймано стандартное исключение Java:");
            System.out.println("   Тип: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
            System.out.println("\n КАК ИЗБЕЖАТЬ ОШИБКИ:");
            System.out.println("   Всегда проверяйте длину массива: array.length");
            System.out.println("   Правильно: if (index >= 0 && index < array.length)");
        }

        // ----- ЕЩЕ ОДИН ПРИМЕР С ДВУМЕРНЫМ МАССИВОМ -----
        System.out.println("\n\n ТЕСТ 5: Еще один пример с двумерным массивом");

        try {
            String[][] testArray = {
                    {"100", "200"},
                    {"300", "400", "500"}  // разное количество столбцов
            };

            printArray(testArray, "testArray");
            processArray(testArray);

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(" Поймано исключение: " + e.getMessage());
        }

        System.out.println("\n========== ПРОГРАММА ЗАВЕРШЕНА ==========");
    }
}
