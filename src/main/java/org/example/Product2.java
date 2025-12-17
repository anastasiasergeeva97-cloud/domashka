package org.example;

public class Product2 {
    //Поля класса
    private String
            name ;
    private String
            productionDate ;
    // Дата производства
    private String
            manufacturer ;
    // Производитель
    private String
            country ;
    //страна
    private double
            price ;
    //цена
    private  boolean
            isReserved ;
    //состояние бронирования покупателем

    //Конструктор
    public Product2(String name, String productionData, String manufacturer, String country, double price, boolean isReserved) {
        this.name=name ;
        //название
        this.manufacturer=manufacturer;
        this.country=country;
        this.price=price;
        this.isReserved=isReserved;
    }
    //Метод для вывода информации
    public void printInfo() {
        System.out.println("===Информация о товаре ===");
        System.out.println("Название:" + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.printf("Цена: %.2f руб.%n", price);
        System.out.println("Забронирован: " + (isReserved ? "Да" : "Нет"));
        System.out.println("===========================");
    }
    // Геттеры и сеттеры (опционально, но рекомендуется)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}