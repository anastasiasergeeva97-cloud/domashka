package org.example;

public class Main {
    public static void main(String[] args) {
        // Создаем массив из 5 товаров
        int i1 = 5;
        Product2[] productsArray = new Product2 [5];

        // Заполняем массив объектами
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);

        productsArray[1] = new Product("iPhone 16 Pro", "15.01.2025",
                "Apple Inc.", "USA", 6499, false);

        productsArray[2] = new Product("Xiaomi 14", "10.03.2025",
                "Xiaomi Corporation", "China", 3999, true);

        productsArray[3] = new Product("Nokia G42", "20.02.2025",
                "HMD Global", "Finland", 1299, false);

        productsArray[4] = new Product("Google Pixel 8", "05.01.2025",
                "Google LLC", "USA", 4599, true);

        // Выводим информацию о всех товарах
        System.out.println("СПИСОК ТОВАРОВ:");
        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("\nТовар #" + (i + 1));
            productsArray[i].printInfo();
        }

        // Альтернативный вывод с использованием foreach
        System.out.println("\n\nВывод через foreach:");
        for (Product2 product : productsArray) {
            product.printInfo();
        }
        // ========== КОД ДЛЯ ПАРКА ==========

        System.out.println("\n\n" + "=".repeat(50));
        System.out.println("ДЕМОНСТРАЦИЯ РАБОТЫ С КЛАССОМ PARK");
        System.out.println("=".repeat(50));

        // Создаем парк
        Park2 disneyland = new Park("Диснейленд", 3);
        System.out.println("Создан парк: " + disneyland.getParkName());

        // Добавляем аттракционы
        disneyland.addAttraction(0, "Американские горки", "10:00-20:00", 1500);
        disneyland.addAttraction(1, "Колесо обозрения", "09:00-22:00", 800);
        disneyland.addAttraction(2, "Комната страха", "12:00-23:00", 1200);

        // Показываем все аттракционы
        disneyland.displayAllAttractions();

        // Демонстрация внутреннего класса
        System.out.println("\nДемонстрация создания объекта внутреннего класса:");
        Park.Attraction newAttraction = disneyland.new Attraction("Водные горки", "11:00-19:00", 1700);
        newAttraction.displayInfo();
    }
}
