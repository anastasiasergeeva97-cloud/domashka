package org.example;
import java.util.*;

// Класс Student
class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades; // предмет -> оценка

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }

    // Метод для добавления оценки по предмету
    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    // Метод для расчета среднего балла
    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Метод для перевода на следующий курс
    public void promoteToNextCourse() {
        this.course++;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<String, Integer> getGrades() {
        return new HashMap<>(grades); // возвращаем копию для инкапсуляции
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", averageGrade=" + String.format("%.2f", calculateAverageGrade()) +
                '}';
    }

    // Переопределяем equals и hashCode для корректной работы с Set
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course);
    }
}

// Основной класс с методами работы со студентами
class StudentManager {

    // Метод удаляет студентов со средним баллом < 3
    public static void removeStudentsWithLowGrades(Set<Student> students) {
        // Используем итератор для безопасного удаления во время итерации
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.calculateAverageGrade() < 3.0) {
                iterator.remove();
                System.out.println("Студент " + student.getName() + " отчислен.");
            }
        }
    }

    // Метод переводит студентов на следующий курс, если средний балл >= 3
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.calculateAverageGrade() >= 3.0) {
                System.out.println("Студент " + student.getName() +
                        " переведен с курса " + student.getCourse() +
                        " на курс " + (student.getCourse() + 1));
                student.promoteToNextCourse();
            }
        }
    }

    // Метод печатает имена студентов, обучающихся на данном курсе
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("\nСтуденты " + course + " курса:");
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName() + " (группа: " + student.getGroup() +
                        ", средний балл: " + String.format("%.2f", student.calculateAverageGrade()) + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("На " + course + " курсе нет студентов.");
        }
    }

    // Метод для печати всех студентов
    public static void printAllStudents(Set<Student> students) {
        System.out.println("\nВсе студенты:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        // Создаем коллекцию студентов
        Set<Student> students = new HashSet<>();

        // Создаем студентов
        Student student1 = new Student("Иван Иванов", "ИС-101", 1);
        student1.addGrade("Математика", 4);
        student1.addGrade("Физика", 3);
        student1.addGrade("Программирование", 5);

        Student student2 = new Student("Петр Петров", "ИС-101", 1);
        student2.addGrade("Математика", 2);
        student2.addGrade("Физика", 2);
        student2.addGrade("Программирование", 3);

        Student student3 = new Student("Анна Сидорова", "ИС-102", 2);
        student3.addGrade("Математика", 5);
        student3.addGrade("Физика", 4);
        student3.addGrade("Программирование", 5);

        Student student4 = new Student("Мария Кузнецова", "ИС-102", 2);
        student4.addGrade("Математика", 3);
        student4.addGrade("Физика", 3);
        student4.addGrade("Программирование", 3);

        // Добавляем студентов в коллекцию
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        // Выводим всех студентов
        StudentManager.printAllStudents(students);

        // Печатаем студентов 1 курса
        StudentManager.printStudents(students, 1);

        // Удаляем студентов с низким средним баллом
        System.out.println("\n--- Проверка успеваемости ---");
        StudentManager.removeStudentsWithLowGrades(students);

        // Переводим студентов на следующий курс
        StudentManager.promoteStudents(students);

        // Выводим обновленный список студентов
        System.out.println("\n--- После сессии ---");
        StudentManager.printAllStudents(students);

        // Печатаем студентов 2 курса
        StudentManager.printStudents(students, 2);
    }
}
