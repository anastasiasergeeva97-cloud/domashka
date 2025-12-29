package org.example;
// Основной класс для тестирования
public class Main3 {
    public static void main(String[] args) {
        System.out.println("=== Часть 1: Животные ===");

        // Создаем животных
        Dog dog1 = new Dog(" Бобик");
        Dog dog2 = new Dog(" Шарик");
        Cat cat1 = new Cat(" Мурзик");
        Cat cat2 = new Cat(" Барсик");
        Cat cat3 = new Cat(" Васька");

        // Тестируем бег и плавание
        dog1.run(400);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(15);

        cat1.run(150);
        cat1.run(250);
        cat1.swim(10);

        System.out.println("\n=== Часть  2: Коты и миска ===");

        // Создаем миску и массив котов
        Bowl bowl = new Bowl(20);
        Cat[] cats = {cat1, cat2, cat3};

        System.out.println("В миске изначально: " + bowl.getFoodAmount() + " еды");

        // Просим котов покушать
        for (Cat cat : cats) {
            cat.eatFromBowl(bowl, 8);
        }

        // Проверяем сытость котов
        System.out.println("\nСтатус сытости котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isFull() ? "сыт" : "голоден"));
        }

        System.out.println("В миске осталось: " + bowl.getFoodAmount() + " еды");

        // Добавляем еду в миску
        bowl.addFood(15);

        // Пробуем покормить голодных котов снова
        System.out.println("\nДокармливаем котов:");
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eatFromBowl(bowl, 8);
            }
        }

        // Статистика
        System.out.println("\n=== Статистика ===");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак создано: " + Dog.getDogCount());
        System.out.println("Котов создано: " + Cat.getCatCount());
    }
}