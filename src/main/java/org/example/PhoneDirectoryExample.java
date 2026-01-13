package org.example;
import java.util.*;

// Телефонный Справочник
class PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        // Используем TreeMap для автоматической сортировки по фамилиям
        directory = new TreeMap<>();
    }

    // Метод для добавления записи (фамилия -> номер телефона)
    public void add(String lastName, String phoneNumber) {
        // Если фамилии еще нет в справочнике, создаем новый список
        directory.putIfAbsent(lastName, new ArrayList<>());

        // Добавляем номер телефона в список для данной фамилии
        directory.get(lastName).add(phoneNumber);

        System.out.println("Добавлена запись: " + lastName + " - " + phoneNumber);
    }

    // Метод для поиска номеров телефонов по фамилии
    public List<String> get(String lastName) {
        // Возвращаем список номеров или пустой список, если фамилия не найдена
        return directory.getOrDefault(lastName, Collections.emptyList());
    }

    // Метод для вывода всех записей справочника
    public void printAll() {
        System.out.println("\nТелефонный справочник:");
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Метод для поиска и вывода номеров телефонов по фамилии
    public void findAndPrint(String lastName) {
        List<String> phones = get(lastName);
        if (phones.isEmpty()) {
            System.out.println("Фамилия '" + lastName + "' не найдена в справочнике.");
        } else {
            System.out.println("Найдены номера для фамилии '" + lastName + "':");
            for (int i = 0; i < phones.size(); i++) {
                System.out.println((i + 1) + ". " + phones.get(i));
            }
        }
    }
}

// исп. телефонного справочника
public class PhoneDirectoryExample {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();

        // Добавляем записи в справочник
        directory.add("Иванов", "+7-900-123-45-67");
        directory.add("Петров", "+7-901-234-56-78");
        directory.add("Иванов", "+7-902-345-67-89"); // Второй номер для Иванова
        directory.add("Сидорова", "+7-903-456-78-90");
        directory.add("Петров", "+7-904-567-89-01"); // Второй номер для Петрова
        directory.add("Иванов", "+7-905-678-90-12"); // Третий номер для Иванова (однофамилец)

        // Выводим весь справочник
        directory.printAll();

        System.out.println("\n--- Поиск по фамилиям ---");

        // Ищем номера телефонов
        directory.findAndPrint("Иванов");
        directory.findAndPrint("Петров");
        directory.findAndPrint("Сидорова");
        directory.findAndPrint("Кузнецов"); // Несуществующая фамилия

        // Пример использования метода get() напрямую
        System.out.println("\n--- Прямое использование метода get() ---");
        List<String> ivanovPhones = directory.get("Иванов");
        System.out.println("Номера Иванова (полученные через get()): " + ivanovPhones);
    }
}
