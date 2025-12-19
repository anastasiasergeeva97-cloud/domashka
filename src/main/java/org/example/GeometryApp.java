package org.example;
import java.awt.Color;

// Интерфейс для геометрических фигур
interface GeometricFigure {
    double calculatePerimeter();
    double calculateArea();
    Color getFillColor();
    Color getBorderColor();

    // Дефолтный метод для вывода информации
    default void printInfo() {
        System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()) +
                ", Площадь: " + String.format("%.2f", calculateArea()) +
                ", Цвет фона: " + colorToString(getFillColor()) +
                ", Цвет границ: " + colorToString(getBorderColor()));
    }

    // Вспомогательный метод для преобразования цвета в строку
    private String colorToString(Color color) {
        if (color == Color.RED) return "Красный";
        if (color == Color.GREEN) return "Зеленый";
        if (color == Color.BLUE) return "Синий";
        if (color == Color.YELLOW) return "Желтый";
        if (color == Color.BLACK) return "Черный";
        if (color == Color.WHITE) return "Белый";
        return "Пользовательский цвет";
    }
}

// Класс Круг
class Circle implements GeometricFigure {
    private double radius;
    private Color fillColor;
    private Color borderColor;

    public Circle(double radius, Color fillColor, Color borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }

    public double getRadius() {
        return radius;
    }
}

// Класс Прямоугольник
class Rectangle implements GeometricFigure {
    private double width;
    private double height;
    private Color fillColor;
    private Color borderColor;

    public Rectangle(double width, double height, Color fillColor, Color borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

// Класс Треугольник
class Triangle implements GeometricFigure {
    private double sideA;
    private double sideB;
    private double sideC;
    private Color fillColor;
    private Color borderColor;

    public Triangle(double sideA, double sideB, double sideC, Color fillColor, Color borderColor) {
        if (isValidTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        } else {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        // Используем формулу Герона
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}

// Основной класс для тестирования геометрических фигур
public class GeometryApp {
    public static void main(String[] args) {
        System.out.println("=== Расчет характеристик геометрических фигур ===\n");

        // Создаем фигуры
        GeometricFigure circle = new Circle(5.0, Color.RED, Color.BLACK);
        GeometricFigure rectangle = new Rectangle(4.0, 6.0, Color.GREEN, Color.BLUE);
        GeometricFigure triangle = new Triangle(3.0, 4.0, 5.0, Color.YELLOW, Color.RED);

        // Выводим информацию о фигурах
        System.out.println("Круг:");
        circle.printInfo();

        System.out.println("\nПрямоугольник:");
        rectangle.printInfo();

        System.out.println("\nТреугольник:");
        triangle.printInfo();

        // Дополнительные фигуры для демонстрации
        System.out.println("\n\n=== Дополнительные фигуры ===\n");

        GeometricFigure[] figures = {
                new Circle(7.5, Color.BLUE, Color.WHITE),
                new Rectangle(8.0, 3.0, Color.YELLOW, Color.BLACK),
                new Triangle(5.0, 12.0, 13.0, Color.GREEN, Color.RED)
        };

        for (int i = 0; i < figures.length; i++) {
            System.out.println("Фигура " + (i + 1) + ":");
            figures[i].printInfo();
            System.out.println();
        }
    }
}