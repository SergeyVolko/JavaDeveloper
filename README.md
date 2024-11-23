# Информация о проекте
## Домашнее задание №1
### Знакомство с языком Java и инструментами
Скриншот компиляции и запуска программы из первого пункта задания:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework1/src/main/screen/%D0%A1%D0%BA%D1%80%D0%B8%D0%BD%D1%88%D0%BE%D1%821.png?raw=true)<br>
Ответ: MzAxMjM0MA==<br><br>
Скриншот запуска программы из второй части задания.
![Скриншот2](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework1/src/main/screen/%D0%A1%D0%BA%D1%80%D0%B8%D0%BD%D1%88%D0%BE%D1%822.png?raw=true)<br>
Ответ: MTAyNDcyMzU=
## Домашнее задание №2
### Базовый синтаксис Java
Скриншот компиляции и работы программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework2/src/screen/%D0%94%D0%B7%E2%84%962.png?raw=true)<br><br>
Исходный код:
```java
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Расскажите о вашем друге");
        System.out.println("Как зовут вашего друга");
        String name = scanner.nextLine();
        System.out.println("Сколько лет вашему другу");
        String age = scanner.nextLine();
        System.out.println("Моему другу " + name + " на данный момент " + age + " лет");
    }
}
```
## Домашнее задание №3
### Переменные и типы данных в Java
Скриншот компиляции и работы программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework3/src/screen/%D0%94%D0%97%E2%84%963.png?raw=true)<br><br>
Исходный код класса WorkShop:
```java
import java.util.Arrays;

public class WorkShop {
    public static void main(String[] args) {
        Friend[] myFriends = {
                new Friend("Вася", 25, true, 4.56f),
                new Friend("Лиза", 23, false, 3.22f),
                new Friend("Петя", 20, true, 2.11f),
                new Friend("Саша", 21, false, 6.34f),
                new Friend("Иван", 29, true, 5.32f),
                new Friend("Петр", 30, false, 9.36f)
        };

        System.out.println(Arrays.toString(myFriends));
    }
}
```
Исходный код класса Friend:
```java
public class Friend {
    private String name;
    private int age;
    private boolean isFriendFromSchool;
    private float hoursSpentTogetherLastWeek;

    public Friend(String name, int age, boolean isFriendFromSchool, float hoursSpentTogetherLastWeek) {
        this.name = name;
        this.age = age;
        this.isFriendFromSchool = isFriendFromSchool;
        this.hoursSpentTogetherLastWeek = hoursSpentTogetherLastWeek;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isFriendFromSchool=" + isFriendFromSchool +
                ", hoursSpentTogetherLastWeek=" + hoursSpentTogetherLastWeek +
                '}';
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=60121:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework3 WorkShop
[Friend{name='Вася', age=25, isFriendFromSchool=true, hoursSpentTogetherLastWeek=4.56}, Friend{name='Лиза', age=23, isFriendFromSchool=false, hoursSpentTogetherLastWeek=3.22}, Friend{name='Петя', age=20, isFriendFromSchool=true, hoursSpentTogetherLastWeek=2.11}, Friend{name='Саша', age=21, isFriendFromSchool=false, hoursSpentTogetherLastWeek=6.34}, Friend{name='Иван', age=29, isFriendFromSchool=true, hoursSpentTogetherLastWeek=5.32}, Friend{name='Петр', age=30, isFriendFromSchool=false, hoursSpentTogetherLastWeek=9.36}]

Process finished with exit code 0
```
## Домашнее задание №4
### Циклы и языковые конструкции в Java
Скриншот компиляции и работы программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework4/src/screen/%D0%94%D0%B7%E2%84%964.png?raw=true)<br><br>
Исходный код класса Solution:
```java
import java.util.Scanner;

public class Solution {
    private static final int NUM_THREE = 3;
    private static final int NUM_FIVE = 5;
    private static final String TEXT_THREE = "fizz";
    private static final String TEXT_FIVE = "buzz";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("0");
        for (int i = 1; i <= n; i++) {
            if (i % NUM_THREE == 0 && i % NUM_FIVE == 0) {
                System.out.print(" " + TEXT_THREE + TEXT_FIVE);
            } else if (i % NUM_THREE == 0) {
                System.out.print(" " + TEXT_THREE);
            } else if (i % NUM_FIVE == 0) {
                System.out.print(" " + TEXT_FIVE);
            } else {
                System.out.print(" " + i);
            }
        }
        scanner.close();
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=49911:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework4 Solution
Введите целое число: 15
0 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz
Process finished with exit code 0
```
## Домашнее задание №5
### Структуры данных
Скриншот компиляции и работы программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework5/src/screen/%D0%94%D0%97%E2%84%965.png?raw=true)<br><br>
Исходный код класса DynamicArray:
```java
import java.util.Arrays;

public class DynamicArray {
    static int max_size = 2;
    static int size = 0;
    static int[] data = new int[max_size];

    public static void main(String[] args) {
        add(4);
        add(3);
        add(1);
        add(5);
        print(); // должно вывести 4,3,1,5
        sort();
        print(); // должно вывести 1,3,4,5
    }

    static void sort() {
        for(int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    static void print() {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println(" ]");
    }

    static void add(int value) {
        if (size >= data.length) {
            max_size *= 2;
            int[] temp = Arrays.copyOf(data, size);
            data = new int[max_size];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
        data[size] = value;
        size++;
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50109:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework5 DynamicArray
[ 4 3 1 5 ]
[ 1 3 4 5 ]

Process finished with exit code 0
```
## Домашнее задание №6
### Классы и объекты: начальный уровень
#### Задание №1
Исходный код класса Human:
```java
package task1;

public abstract class Human {
    private int age;
    private String name;
    private boolean gender;

    public Human(int age, String name, boolean gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public abstract void doTheWork();
}
```
Исходный код класса Student:
```java
package task1;

public class Student extends Human {
    private String specialization;

    public Student(int age, String name, boolean gender, String specialization) {
        super(age, name, gender);
        this.specialization = specialization;
    }

    public void tellSpecialization() {
        System.out.println("My specialization is " + specialization);
    }

    @Override
    public void doTheWork() {
        System.out.println("I'm in college");
    }
}
```
Исходный код класса AssociateProfessor:
```java
package task1;

public class AssociateProfessor extends Human {
    private String academicDegree;

    public AssociateProfessor(int age, String name, boolean gender, String academicDegree) {
        super(age, name, gender);
        this.academicDegree = academicDegree;
    }

    public void tellAcademicDegree() {
        System.out.println("My academic degree is " + academicDegree);
    }

    @Override
    public void doTheWork() {
        System.out.println("I teach students");
    }
}
```
#### Задание №2
Скриншот компиляции и работы программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework6/src/screen/%D0%94%D0%97%E2%84%966.png?raw=true)<br><br>
Исходный код класса Main:
```java
package task2;

import task1.AssociateProfessor;
import task1.Human;
import task1.Student;

public class Main {

    public static void main(String[] args) {
        Student student = new Student(20, "Вася", true, "Economy");
        AssociateProfessor professor = new AssociateProfessor(50, "Петр", true, "PhD");
        student.tellSpecialization();
        professor.tellAcademicDegree();
        Human[] humans = {student, professor};
        humans[0].doTheWork();
        humans[1].doTheWork();
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50138:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework6 task1.Main
My specialization is Economy
My academic degree is PhD
I'm in college
I teach students

Process finished with exit code 0
```
## Домашнее задание №7
### Классы и объекты: продвинутый уровень
Исходный код класса Car:
```java
package cars;

import carsclasses.Drivable;

public abstract class Car implements Drivable {
    private String name;
    private int hp;
    private int weight;
    private Wheel wheel;
    private Engine engine;
    private CarType carType;

    public Car(String name, int hp, int weight) {
        this.name = name;
        this.hp = hp;
        this.weight = weight;
        this.wheel = new Wheel();
        this.engine = new Engine();
    }

    public Car(String name, int hp, int weight, CarType carType) {
        this(name, hp, weight);
        this.carType = carType;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
```
Исходный код класса CarType:
```java
package cars;

public enum CarType {
    SEDAN, WAGON, COUPE, CONVERTIBLE, SUV
}
```
Исходный код класса Engine:
```java
package cars;
public class Engine {

    public void startEngine(){
        System.out.println("Engine Started");
    }

    public void stopEngine(){
        System.out.println("Engine Stopped");
    }
}

```
Исходный код класса Main:
```java
package cars;

import carsclasses.CombustionCar;
import carsclasses.ElectricCar;

public class Main {

    public static void main(String[] args) {
        Car mazdaCx5 = new CombustionCar("Mazda", 120, 2200, CarType.SUV);
        Car bmwm3 = new CombustionCar("BMW M3", 220, 1800, CarType.SEDAN);
        Car nissanLeaf = new ElectricCar("Nissan Leaf", 110, 1400, CarType.SEDAN);

        testTheCar(mazdaCx5);
        System.out.println("-".repeat(50));
        testTheCar(bmwm3);
        System.out.println("-".repeat(50));
        testTheCar(nissanLeaf);
    }

    public static void testTheCar(Car car){
        System.out.println("Name: " + car.getName() + "\n" +
                "HP: " + car.getHp() + "\n" +
                "Weight: " + car.getWeight());
        car.drive();
    }
}
```
Исходный код класса Wheel:
```java
package cars;

public class Wheel {
    public void steer(){
        System.out.println("Steer the wheel");
    }
}
```
Исходный код класса CombustionCar:
```java
package carsclasses;

import cars.CarType;
import cars.Car;

public class CombustionCar extends Car {
    public CombustionCar(String name, int hp, int weight, CarType carType) {
        super(name, hp, weight, carType);
    }

    @Override
    public void drive() {
        getEngine().startEngine();
        getWheel().steer();
        getEngine().stopEngine();
    }
}
```
Исходный код интерфейса Drivable:
```java
package carsclasses;

public interface Drivable {
    public void drive();
}
```
Исходный код класса ElectricCar:
```java
package carsclasses;

import cars.CarType;
import cars.Car;

public class ElectricCar extends Car {

    public ElectricCar(String name, int hp, int weight, CarType carType) {
        super(name, hp, weight, carType);
    }

    @Override
    public void drive() {
        getWheel().steer();
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50222:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework7 cars.Main
Name: Mazda
HP: 120
Weight: 2200
Engine Started
Steer the wheel
Engine Stopped
--------------------------------------------------
Name: BMW M3
HP: 220
Weight: 1800
Engine Started
Steer the wheel
Engine Stopped
--------------------------------------------------
Name: Nissan Leaf
HP: 110
Weight: 1400
Steer the wheel

Process finished with exit code 0
```
## Домашнее задание №8
### Методы и поля классов
Скриншот компиляции и работы программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework8/src/com/example/screen/%D0%94%D0%97%E2%84%968.png?raw=true)<br><br>
Исходный код класса Circle:
```java
package com.example.circle;

/**
 * Заполните этот класс в соответсвии с заданием из лекции.
 */
public class Circle {
    private double radius;

    public Circle(double radius) {
        checkingRadius(radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        checkingRadius(radius);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    private void checkingRadius(double radius) {
        if (radius < 0) {
            throw new RuntimeException("Radius less than zero");
        }
    }
}
```
Исходный код класса Main:
```java
package com.example;

public class Main {
    public static void main(String[] args) {
        TestCircle test = new TestCircle();
        test.test();
    }
}
```
Исходный код класса TestCircle:
```java
package com.example;

import com.example.circle.Circle;

public class TestCircle {

    private final double EPSILON = 0.00001;

    private boolean compareDouble(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }

    private void testCreateCircle() {
        Circle circle = new Circle(10);
        double radius = circle.getRadius();
        if (compareDouble(radius, 10.0)) {
            System.out.println("testCreateCircle: OK");
        } else {
            System.out.println("testCreateCircle: FAILURE");
        }
    }

    private void testSetRadius() {
        Circle circle = new Circle(1);
        if (!compareDouble(circle.getRadius(), 1)) {
            System.out.println("testSetRadius: FAILURE: expected getRadius() = 1, got " + circle.getRadius());
            return;
        }
        circle.setRadius(2.0);
        if (!compareDouble(circle.getRadius(), 2)) {
            System.out.println("testSetRadius: FAILURE: expected r = 2, got " + circle.getRadius());
            return;
        } else {
            System.out.println("testSetRadius: OK");
        }
    }

    private void testGetArea() {
        Circle circle = new Circle(2);
        if (compareDouble(circle.getArea(), Math.PI * 4)) {
            System.out.println("testGetArea: OK");
        } else {
            System.out.println("testGetArea: FAILURE");
        }
    }

    private void testCreateRadiusLessZero(double radius) {
        try {
            Circle circle = new Circle(radius);
            if (radius < 0) {
                System.out.println("testCreateRadiusLessZero: FAILURE");
                return;
            }
            System.out.println("testCreateRadiusLessZero: OK");
        } catch (RuntimeException e) {
            System.out.println("testCreateRadiusLessZero: OK");
        }
    }

    private void testSetRadiusLessZero(double radius, Circle circle) {
        try {
            circle.setRadius(radius);
            if (radius < 0) {
                System.out.println("testSetRadiusLessZero: FAILURE");
                return;
            }
            System.out.println("testSetRadiusLessZero: OK");
        } catch (RuntimeException e) {
            System.out.println("testSetRadiusLessZero: OK");
        }
    }

    public void test() {
        testCreateCircle();
        testSetRadius();
        testGetArea();
        testCreateRadiusLessZero(-1);
        testCreateRadiusLessZero(1);
        Circle circle = new Circle(1);
        testSetRadiusLessZero(-1, circle);
        testSetRadiusLessZero(1, circle);
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50231:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework8 com.example.Main
testCreateCircle: OK
testSetRadius: OK
testGetArea: OK
testCreateRadiusLessZero: OK
testCreateRadiusLessZero: OK
testSetRadiusLessZero: OK
testSetRadiusLessZero: OK

Process finished with exit code 0
```