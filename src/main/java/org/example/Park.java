package org.example;

public class Park {
    private String parkName;
    private Attraction[] attractions;  // массив аттракционов

    // Конструктор парка
    public Park2(String parkName, int capacity) {
        this.parkName = parkName;
        this.attractions = new Attraction[capacity];
    }

    // ВНУТРЕННИЙ КЛАСС для аттракционов
    public class Attraction {
        private String attractionName;
        private String workHours;
        private double price;

        // Конструктор аттракциона
        public Attraction(String attractionName, String workHours, double price) {
            this.attractionName = attractionName;
            this.workHours = workHours;
            this.price = price;
        }

        // Метод для вывода информации об аттракционе
        public void displayInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workHours);
            System.out.printf("Стоимость: %.2f руб.%n", price);
            System.out.println("Расположен в парке: " + parkName);  // доступ к полю внешнего класса
            System.out.println("-------------------");
        }

        // Геттеры
        public String getAttractionName() {
            return attractionName;
        }

        public String getWorkHours() {
            return workHours;
        }

        public double getPrice() {
            return price;
        }
    }

    // Метод для добавления аттракциона
    public void addAttraction(int index, String name, String hours, double price) {
        if (index >= 0 && index < attractions.length) {
            attractions[index] = new Attraction(name, hours, price);
        }
    }

    // Метод для отображения всех аттракционов
    public void displayAllAttractions() {
        System.out.println("=== Аттракционы парка \"" + parkName + "\" ===");
        for (Attraction attraction : attractions) {
            if (attraction != null) {
                attraction.displayInfo();
            }
        }
    }

    // Метод для поиска аттракциона по имени
    public Attraction findAttraction(String name) {
        for (Attraction attraction : attractions) {
            if (attraction != null && attraction.getAttractionName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }

    // Геттер для названия парка
    public String getParkName() {
        return parkName;
    }
}
