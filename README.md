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
## Домашнее задание №9
### Обработка исключений
Исходный код класса Main:
```java
import exception.AccessDeniedException;
import exception.InsufficientAmountException;

public class Main {
    public static String accountName = "MyAcc";
    public static int amount = 10000;

    public static void main(String[] args) throws InsufficientAmountException {
        System.out.println(deduct("MyAcc", 900));
    }

    public static int deduct(String accountToProcess, int amtToCacheOut) throws InsufficientAmountException {
        if (!accountName.equals(accountToProcess)){
            throw new AccessDeniedException("Provided account doesn't match the target one");
        }
        if (amount < amtToCacheOut){
            throw new InsufficientAmountException("Not enough money to withdraw " + amtToCacheOut);
        }
        amount = amount - amtToCacheOut;
        return amount;
    }


}
```
Исходный код класса AccessDeniedException:
```java
package exception;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException() {
    }

    public AccessDeniedException(String message) {
        super(message);
    }
}
```
Исходный код класса InsufficientAmountException:
```java
package exception;

public class InsufficientAmountException extends Exception {
    public InsufficientAmountException() {
    }

    public InsufficientAmountException(String message) {
        super(message);
    }
}
```
## Домашнее задание №10
### Работа с массивами
Скриншот сборки программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/arrays-homework-main/src/main/java/screen/%D0%94%D0%B7%E2%84%9610.png?raw=true)<br><br>
Исходный код класса `DefaultCustomArrayList`:
```java
package com.edu;

import java.util.*;
import java.util.stream.IntStream;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 5;
    private static final int MULTIPLE_CAPACITY = 2;
    private Object[] data;
    private int size;
    private final int maxCapacity;
    int modCount = 0;

    public DefaultCustomArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.maxCapacity = Integer.MAX_VALUE;
    }

    public DefaultCustomArrayList(int maxCapacity) {
        this.data = new Object[DEFAULT_CAPACITY];
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean add(E element) {
        if (size == maxCapacity) {
            return false;
        }
        modCount++;
        if (data.length == size) {
            data = Arrays.copyOf(data, data.length * MULTIPLE_CAPACITY);
        }
        data[size++] = element;
        return true;
    }

    @Override
    public boolean remove(E element) {
        int index = getIndex(element);
        if (index < 0) {
            return false;
        }
        modCount++;
        remove(index);
        return true;
    }

    private void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        modCount++;
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
    }

    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        modCount++;
    }

    @Override
    public boolean contains(E element) {
        return getIndex(element) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private int getIndex(E element) {
        return IntStream.range(0, data.length)
                .filter(i -> Objects.equals(element, data[i]))
                .findFirst()
                .orElse(-1);
    }

    private class Itr implements Iterator<E> {
        int cursor;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            checkForComodification();
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            Object[] data = DefaultCustomArrayList.this.data;
            return (E) data[cursor++];
        }

        private void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
```
Вывод результата выполнения команды `mvn clean install`:
```text
Microsoft Windows [Version 10.0.19045.5131]
(c) Microsoft Corporation. All rights reserved.

C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main>mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< com.example:custom-arraylist >--------------------
[INFO] Building custom-arraylist 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ custom-arraylist ---
[INFO] Deleting C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ custom-arraylist ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ custom-arraylist ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\target\classes
[WARNING] /C:/Users/Lenovo/IdeaProjects/JavaDeveloperProductStar/arrays-homework-main/src/main/java/com/edu/DefaultCustomArrayList.java: C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\src\main\java\com\edu\DefaultCustomArrayList.java uses unchecked or unsafe operations.
[WARNING] /C:/Users/Lenovo/IdeaProjects/JavaDeveloperProductStar/arrays-homework-main/src/main/java/com/edu/DefaultCustomArrayList.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ custom-arraylist ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ custom-arraylist ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\target\test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:3.0.0-M5:test (default-test) @ custom-arraylist ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running DefaultCustomArrayListTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.264 s - in DefaultCustomArrayListTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ custom-arraylist ---
[INFO] Building jar: C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\target\custom-arraylist-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ custom-arraylist ---
[INFO] Installing C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\target\custom-arraylist-1.0-SNAPSHOT.jar to C:\Users\Lenovo\.m2\repository\com\example\custom-arraylist\1.0-SNAPSHOT\custom-arraylist-1.0-SNAPSHOT.jar
[INFO] Installing C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\pom.xml to C:\Users\Lenovo\.m2\repository\com\example\custom-arraylist\1.0-SNAPSHOT\custom-arraylist-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.485 s
[INFO] Finished at: 2024-11-24T08:17:17+03:00
[INFO] ------------------------------------------------------------------------

C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main>
```
## Домашнее задание №11
### Строки и регулярные выражения
Исходный код класса `Solution`:
```java
public class Solution {
    private static final String REGEX_E = "[^(е|e)]";
    private static final String REGEX_PHONE = "^\\+\\d{1,4}\\(\\d{1,4}\\)\\d{1,4}-\\d{1,4}-\\d{1,4}$";
    private static final String REGEX_REMOVE_LETTER_AND_SPACES = "[a-zA-Zа-я\\s]+";

    public static void main(String[] args) {
        System.out.println(countTheNumberOfLettersE("dgedje"));
        System.out.println(countTheNumberOfLettersE("Домашнее задание"));
        System.out.println(validatePhone("+7(746)982-23-45"));
        System.out.println(validatePhone("+7(746)98223-45"));
        System.out.println(removeLetterAndSpace("jrf jfr6jr jака5f"));
    }

    public static int countTheNumberOfLettersE(String text) {
        return text.replaceAll(REGEX_E, "").length();
    }

    public static boolean validatePhone(String phone) {
        return phone.matches(REGEX_PHONE);
    }

    public static String removeLetterAndSpace(String text) {
        return text.replaceAll(REGEX_REMOVE_LETTER_AND_SPACES, "");
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=61231:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework11 Solution
2
3
true
false
65

Process finished with exit code 0
```
## Домашнее задание №12
### Знакомство с алгоритмами
Скриншот компиляции и работы программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework12/src/screen/%D0%94%D0%97%E2%84%9612.png?raw=true)<br><br>
Исходный код класса `SortingAlgorithm`:
```java
package algorithms;

public abstract class SortingAlgorithm {
    private String nameAlgorithm;
    private long time;

    public SortingAlgorithm(String nameAlgorithm) {
        this.nameAlgorithm = nameAlgorithm;
    }

    public abstract void sort(int[] array);

    public String getNameAlgorithm() {
        return nameAlgorithm;
    }

    public long getTime() {
        return time;
    }

    public void sortArrayWithSetTime(int[] array) {
        long startTime = System.currentTimeMillis();
        sort(array);
        this.time = System.currentTimeMillis() - startTime;
    }
}
```
Исходный код класса `BubbleSort`:
```java
package algorithms;

public class BubbleSort  extends SortingAlgorithm {

    public BubbleSort(String nameAlgorithm) {
        super(nameAlgorithm);
    }

    public static void main(String[] args) {
        int[] array = ArrayGenerator.generateUniqueElementArray(10000);
        SortingAlgorithm bubbleSort = new BubbleSort("algorithms.BubbleSort");
        bubbleSort.sortArrayWithSetTime(array);
        System.out.println("Time: " + bubbleSort.getTime());
    }

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
```
Исходный код класса `InsertSort`:
```java
package algorithms;

import java.util.Arrays;

public class InsertSort extends SortingAlgorithm {

    public InsertSort(String nameAlgorithm) {
        super(nameAlgorithm);
    }

    public static void main(String[] args) {
        int[] array = ArrayGenerator.generateUniqueElementArray(10);
        InsertSort insertSort = new InsertSort("algorithms.InsertSort");
        insertSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }
}
```

Исходный код класса `JavaSort`:
```java
package algorithms;

import java.util.Arrays;

public class JavaSort extends SortingAlgorithm {

    public JavaSort(String nameAlgorithm) {
        super(nameAlgorithm);
    }

    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
    }
}
```
Исходный код класса `MergeSort`:
```java
package algorithms;

import java.util.Arrays;

public class MergeSort extends SortingAlgorithm {

    public MergeSort(String nameAlgorithm) {
        super(nameAlgorithm);
    }

    public static void main(String[] args) {
        int[] arr = ArrayGenerator.generateArray(20);
        SortingAlgorithm mergeSort = new MergeSort("algorithms.MergeSort");
        System.out.println(Arrays.toString(arr));
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void sort(int[] array) {
        int[] sortedArray = merge(array);
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    private int[] merge(int[] array) {

        if (array.length == 1) {
            return array;
        }
        int[] left = new int[array.length / 2];
        int[] right = new int[array.length - left.length];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = array[left.length + i];
        }

        left = merge(left);
        right = merge(right);

        return mergeSort(left, right);
    }

    private int[] mergeSort(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (rightIndex == right.length
                    || (leftIndex < left.length && left[leftIndex] < right[rightIndex])) {
                result[i] = left[leftIndex++];
            } else {
                result[i] = right[rightIndex++];
            }
        }
        return result;
    }
}
```
Исходный код класса `SelectionSort`:
```java
package algorithms;

import java.util.Arrays;

public class SelectionSort extends SortingAlgorithm {

    public SelectionSort(String nameAlgorithm) {
        super(nameAlgorithm);
    }

    public static void main(String[] args) {
        int[] array = ArrayGenerator.generateUniqueElementArray(10);
        SortingAlgorithm selectionSort = new SelectionSort("algorithms.SelectionSort");
        System.out.println(Arrays.toString(array));
        selectionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }
}
```
Исходный код класса `ArrayGenerator`:
```java
package algorithms;

import java.util.Random;

public class ArrayGenerator {

    public static int[] generateUniqueElementArray(int size) {
        int[] array = new int[size];
        for (int i = 1; i <= size; i++) {
            array[i - 1] = i;
        }
        shuffle(array);
        return array;
    }

    public static int[] generateArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    private static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i];
            int index = random.nextInt(i, array.length);
            array[i] = array[index];
            array[index] = tmp;
        }
    }
}
```
Исходный код класса `TypeGenerated`:
```java
public enum TypeGenerated {
    UNIQUE, REPEATED
}
```
Исходный код класса `TemporalSortingTester`:
```java
import algorithms.ArrayGenerator;
import algorithms.SortingAlgorithm;
import java.util.Arrays;
import java.util.Objects;

public class TemporalSortingTester {
    private int[] array;
    private SortingAlgorithm[] algorithms;

    public TemporalSortingTester(SortingAlgorithm[] sortingAlgorithms, int dataSize,
                                 TypeGenerated typeGenerated) {
        if (typeGenerated.equals(TypeGenerated.UNIQUE)) {
            this.array = ArrayGenerator.generateUniqueElementArray(dataSize);
        } else {
            this.array = ArrayGenerator.generateArray(dataSize);
        }
        this.algorithms = sortingAlgorithms;
    }

    public void showResult() {
        SortingAlgorithm bestAlgorithm = null;
        for (SortingAlgorithm algorithm : algorithms) {
            algorithm.sortArrayWithSetTime(Arrays.copyOf(array, array.length));
            System.out.printf("Наименование алгоритма: %s\nВремя работы: %d\n"
                    + "-".repeat(50) + "\n", algorithm.getNameAlgorithm(), algorithm.getTime());
            if (bestAlgorithm == null || bestAlgorithm.getTime() > algorithm.getTime()) {
                bestAlgorithm = algorithm;
            }
        }
        System.out.println("+".repeat(50));
        System.out.printf("Лучший алгоритм: %s Время работы: %d\n", Objects.requireNonNull(bestAlgorithm).getNameAlgorithm(),
                bestAlgorithm.getTime());
    }
}
```
Исходный код класса `Main`:
```java
import algorithms.*;

public class Main {
    public static void main(String[] args) {
        SortingAlgorithm[] algorithms = {
                new BubbleSort("Пузырьковая сортировка"),
                new InsertSort("Сортировка вставками"),
                new SelectionSort("Сортировка выбором"),
                new MergeSort("Сортировка слиянием"),
                new JavaSort("Сортировка Java")
        };

        TemporalSortingTester tester = new TemporalSortingTester(algorithms, 100000, TypeGenerated.UNIQUE);
        tester.showResult();
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50246:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework12 Main
Наименование алгоритма: Пузырьковая сортировка
Время работы: 25489
--------------------------------------------------
Наименование алгоритма: Сортировка вставками
Время работы: 5971
--------------------------------------------------
Наименование алгоритма: Сортировка выбором
Время работы: 13566
--------------------------------------------------
Наименование алгоритма: Сортировка слиянием
Время работы: 54
--------------------------------------------------
Наименование алгоритма: Сортировка Java
Время работы: 62
--------------------------------------------------
++++++++++++++++++++++++++++++++++++++++++++++++++
Лучший алгоритм: Сортировка слиянием Время работы: 54

Process finished with exit code 0
```
***Вывод:<br>Cортировка слиянием - лучший алгоритм по скорости, но очень затратен по памяти.<br>
Встроенный в Java алгоритм второй по скорости, менее затратен по памяти и быстро работает на частично отсортированных данных.<br>
В своей практике буду использовать сортировку встроенную в Java***
## Домашнее задание №13
### Обзор коллекций в Java
Скриншот компиляции и работы программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework13/src/%D0%94%D0%B7%E2%84%9613.png?raw=true)<br><br>
Исходный код класса `Solution`:
```java
import java.util.*;

public class Solution {
    private static final int ELEMENTS = 1_000_000;
    private static final int GETTING_ELEMENTS = 1000;

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static Map<String, Integer> swapKeyWithValues(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public static void measureTheTime() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < ELEMENTS; i++) {
            int element = random.nextInt(ELEMENTS);
            arrayList.add(element);
            linkedList.add(element);
        }

        getTimeOfGettingElements(arrayList, "ArrayList");
        getTimeOfGettingElements(linkedList, "LinkedList");
    }

    private static void getTimeOfGettingElements(List<Integer> list, String typeCollection) {
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < GETTING_ELEMENTS; i++) {
            list.get(random.nextInt(ELEMENTS));
        }
        long duration = System.currentTimeMillis() - start;
        System.out.printf("Время выбора элементов по индексу для %s: %d\n", typeCollection, duration);
    }

    public static void deleteDuplicates(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (element == list.get(j)) {
                    list.remove(j);
                }
            }
        }
    }

    public static void deleteDuplicatesWithCollection(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>(list);
        int index = 0;
        int lengthSet = set.size();
        int lengthList = list.size();
        for (int element : set) {
            list.set(index++, element);
        }
        for (int i = 0; i < lengthList - lengthSet; i++) {
            list.remove(list.size() - 1);
        }
    }

    public static List<Integer> deleteDuplicatesWithCollectionAndGetList(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void task1() {
        System.out.println("Задание №1");
        Map<Integer, String> map = Map.of(
                1, "aaaaa",
                2, "bbbbb",
                3, "bbbbb",
                4, "ccccc"
        );
        System.out.println("Начальное значение: " + map);
        System.out.println("Результат: " + swapKeyWithValues(map));
        System.out.println("-".repeat(50));
    }

    public static void task2() {
        System.out.println("Задание №2");
        measureTheTime();
        System.out.println("-".repeat(50));
    }

    public static void task3() {
        System.out.println("Задание №3");

        List<Integer> arrayList = new ArrayList<>(List.of(1, 3, 1, 5, 3, 2, 1));
        System.out.println("Исходный массив: " + arrayList);
        deleteDuplicates(arrayList);
        System.out.println("Результат deleteDuplicates:" + arrayList);
        System.out.println();

        arrayList = new ArrayList<>(List.of(1, 3, 1, 5, 3, 2, 1));
        System.out.println("Исходный массив: " + arrayList);
        deleteDuplicatesWithCollection(arrayList);
        System.out.println("Результат deleteDuplicatesWithCollection:" + arrayList);
        System.out.println();

        arrayList = new ArrayList<>(List.of(1, 3, 1, 5, 3, 2, 1));
        System.out.println("Исходный массив: " + arrayList);
        System.out.println("Результат deleteDuplicatesWithCollectionAndGetList:"
                + deleteDuplicatesWithCollectionAndGetList(arrayList));
        System.out.println("-".repeat(50));
    }
}
```
*Во втором задании разница во времени поиска по индексу в ArrayList и LinkedList вызвана тем, что поиск по индексу
в ArrayList происходит за константное время а в LinkedList за линейное.*<br>
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50244:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework13 Solution
Задание №1
Начальное значение: {4=ccccc, 3=bbbbb, 2=bbbbb, 1=aaaaa}
Результат: {bbbbb=2, ccccc=4, aaaaa=1}
--------------------------------------------------
Задание №2
Время выбора элементов по индексу для ArrayList: 1
Время выбора элементов по индексу для LinkedList: 3836
--------------------------------------------------
Задание №3
Исходный массив: [1, 3, 1, 5, 3, 2, 1]
Результат deleteDuplicates:[1, 3, 5, 2]

Исходный массив: [1, 3, 1, 5, 3, 2, 1]
Результат deleteDuplicatesWithCollection:[1, 3, 5, 2]

Исходный массив: [1, 3, 1, 5, 3, 2, 1]
Результат deleteDuplicatesWithCollectionAndGetList:[1, 3, 5, 2]
--------------------------------------------------

Process finished with exit code 0
```
## Домашнее задание №14
### Коллекции: ArrayList и LinkedList
Исходный код класса `Solution`:
```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 5));
        System.out.println("Исходный массив: " + arr);
        IntStream.rangeClosed(0, arr.size() + 1)
                .forEach((e) -> System.out.println(e +": " + getRollingAverage(arr, e)));
        System.out.println("-".repeat(50));
        System.out.println("Исходный массив: " + arr);
        IntStream.rangeClosed(0, arr.size() + 1)
                .forEach((e) -> System.out.println(e +": " + getRollingAverageWithWindow(arr, e)));
    }

    public static List<Double> getRollingAverage(ArrayList<Integer> arr, int k) {
        List<Double> list = new ArrayList<>();
        int size = arr.size();
        if (k <= 0 || k > size) {
            return list;
        }
        for (int i = 0; i <= size - k; i++) {
            int sum = 0;
            int j;
            for (j = i; j < k + i ; j++) {
                sum += arr.get(j);
            }
            list.add((double) sum / (j - i));
        }
        return list;
    }

    public static List<Double> getRollingAverageWithWindow(ArrayList<Integer> arr, int k) {
        List<Double> list = new ArrayList<>();
        int size = arr.size();
        if (k <= 0 || k > size) {
            return list;
        }
        double sum =0;
        for (int i = 0; i < k; i++) {
            sum += arr.get(i);
        }
        list.add(sum / k);
        for (int i = 1; i < size - k; i++) {
            sum = sum - arr.get(i - 1) + arr.get(i + k);
            list.add(sum / k);
        }
        return list;
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=49965:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework14 Solution
Исходный массив: [1, 2, 3, 5]
0: []
1: [1.0, 2.0, 3.0, 5.0]
2: [1.5, 2.5, 4.0]
3: [2.0, 3.3333333333333335]
4: [2.75]
5: []
--------------------------------------------------
Исходный массив: [1, 2, 3, 5]
0: []
1: [1.0, 3.0, 6.0]
2: [1.5, 3.5]
3: [2.0]
4: [2.75]
5: []

Process finished with exit code 0
```
## Домашнее задание №15. Постановка задачи.

Реализовать учет успеваемости студентов по предметам.

У каждой сдачи есть имя, фамилия, предмет и оценка.

### Требования
- Реализовать интерфейс у которого есть методы
    - добавить сдачу студента (в зачет идет только последняя сдача, хранить все сдачи студента по одному и тому же предмету не нужно)
    - получить сдачу студента по имени и фамилии и предмету
    - вывод средней оценки по предмету
    - вывод студентов кто сдавал более одного раза
    - вывод последних пяти студентов сдавших на отлично по любому предмету
    - вывод всех сданных предметов
- Сделать кеш для вывода средней оценки по предмету за пределами интерфейса `Examination`

### Решение

Скриншот сборки проекта.
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/students/%D0%94%D0%97%E2%84%9615.png?raw=true)<br><br>
Вывод сборки в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe -Dmaven.multiModuleProjectDirectory=C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\students -Djansi.passthrough=true "-Dmaven.home=C:\Program Files\JetBrains\IntelliJIdea2024.1\plugins\maven\lib\maven3" "-Dclassworlds.conf=C:\Program Files\JetBrains\IntelliJIdea2024.1\plugins\maven\lib\maven3\bin\m2.conf" "-Dmaven.ext.class.path=C:\Program Files\JetBrains\IntelliJIdea2024.1\plugins\maven\lib\maven-event-listener.jar" "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50115:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJIdea2024.1\plugins\maven\lib\maven3\boot\plexus-classworlds-2.7.0.jar;C:\Program Files\JetBrains\IntelliJIdea2024.1\plugins\maven\lib\maven3\boot\plexus-classworlds.license" org.codehaus.classworlds.Launcher -Didea.version=2024.1 install
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< org.example:students >------------------------
[INFO] Building students 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ students ---
[INFO] Copying 0 resource from src\main\resources to target\classes
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ students ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 7 source files with javac [debug target 17] to target\classes
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ students ---
[INFO] skip non existing resourceDirectory C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\students\src\test\resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ students ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] Compiling 2 source files with javac [debug target 17] to target\test-classes
[INFO] 
[INFO] --- surefire:3.2.2:test (default-test) @ students ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.pom (4.5 kB at 3.8 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/3.2.2/surefire-providers-3.2.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/3.2.2/surefire-providers-3.2.2.pom (2.5 kB at 14 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.pom (2.7 kB at 15 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.jar (27 kB at 43 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.jar (18 kB at 31 kB/s)
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.students.ExaminationTest
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.320 s -- in org.example.students.ExaminationTest
[INFO] Running org.example.students.TestAverageCache
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.023 s -- in org.example.students.TestAverageCache
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jar:3.3.0:jar (default-jar) @ students ---
[INFO] Building jar: C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\students\target\students-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- install:3.1.1:install (default-install) @ students ---
[INFO] Installing C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\students\pom.xml to C:\Users\Lenovo\.m2\repository\org\example\students\1.0-SNAPSHOT\students-1.0-SNAPSHOT.pom
[INFO] Installing C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\students\target\students-1.0-SNAPSHOT.jar to C:\Users\Lenovo\.m2\repository\org\example\students\1.0-SNAPSHOT\students-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  23.257 s
[INFO] Finished at: 2024-11-28T09:40:41+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
```
# Домашнее задание №15
## Коллекции: TreeMap, TreeSet
Исходный код класса `Student`:
```java
public class Student implements Comparable<Student> {
    private String name;
    private float score;

    public Student(String name, float score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        int result = Float.compare(score, o.score);
        if (result == 0) {
            result = o.name.compareTo(name);
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("[%s %f]", name, score);
    }
}

```
Исходный код класса `ResultsBoard`:
```java
import java.util.List;
import java.util.TreeSet;

public class ResultsBoard {
    private final TreeSet<Student> students = new TreeSet<>();

    public void addStudent(String name, Float score) {
        students.add(new Student(name, score));
    }

    public List<String> top3() {
        return students.descendingSet().stream()
                .limit(3)
                .map(Student::getName)
                .toList();
    }

    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("Petr", 4.5f);
        resultsBoard.addStudent("Ivan", 3.2f);
        resultsBoard.addStudent("Igor", 2.4f);
        resultsBoard.addStudent("Sveta", 4.9f);
        resultsBoard.addStudent("Andrew", 3.1f);

        System.out.println(resultsBoard.students);
        resultsBoard.students.last();
        System.out.println(resultsBoard.students);
        System.out.println(resultsBoard.top3());

        resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("Ivan", 3.0f);
        resultsBoard.addStudent("Maria", 4.0f);
        resultsBoard.addStudent("Oleg", 4.0f);
        System.out.println(resultsBoard.top3());
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=52710:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework15 ResultsBoard
[[Igor 2,400000], [Andrew 3,100000], [Ivan 3,200000], [Petr 4,500000], [Sveta 4,900000]]
[[Igor 2,400000], [Andrew 3,100000], [Ivan 3,200000], [Petr 4,500000], [Sveta 4,900000]]
[Sveta, Petr, Ivan]
[Maria, Oleg, Ivan]

Process finished with exit code 0
```
## Домашнее задание №16
### Stream api, lambda, optional
Исходный код класса `Solution`:
```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        task1(List.of(3, 4, 6, 1, 3, 1, 6));
        task2("a", "hrfufh acr ecdu arfrf jcf aidcn");
        task3(List.of(3, 4, 6, 1, 3, 1, 6));
    }

    public static void task1(List<Integer> list) {
        System.out.println("Исходный список: " + list);
        list = list.stream().distinct().toList();
        System.out.println("Результат: " + list);
    }

    public static void task2(String letter, String text) {
        System.out.printf("Исходный текст: %s\n", text);
        long count = Arrays.stream(text.split(" "))
                .filter(s -> s.startsWith(letter))
                .count();
        System.out.printf("Количество слов начинающихся с буквы %s: %d\n", letter, count);
    }

    public static void task3(List<Integer> list) {
        System.out.println("Исходный список: " + list);
        Integer secondMax = list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.printf("Второй по величине элемент: %d", secondMax);
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50128:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework16 Solution
Исходный список: [3, 4, 6, 1, 3, 1, 6]
Результат: [3, 4, 6, 1]
Исходный текст: hrfufh acr ecdu arfrf jcf aidcn
Количество слов начинающихся с буквы a: 3
Исходный список: [3, 4, 6, 1, 3, 1, 6]
Второй по величине элемент: 4
Process finished with exit code 0
```
## Домашнее задание №19
### Работа с файлами. Адаптер и декоратор
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=52299:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework19 Loader
1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
1
Введите директорию:
C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\homework19\src\data
Введите имя файла:
example.txt
Введите текст файла:
Для выхода из ввода введите exit
private static String getInputText(Scanner scanner) {
        StringBuilder allText = new StringBuilder();
        System.out.println("Для выхода из ввода введите exit");
        while (true) {
            String line = scanner.nextLine();
            if ("exit".equals(line)) {
                break;
            }
            allText.append(line).append("\n"); // Добавляем строку к общему тексту
        }
        return allText.substring(0, allText.length());
    }
exit
Размер файла: 1041 Время загрузки: 4
1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
2
Введите директорию:
homework19/src/data
Введите имя файла:
example.txt
Текст из файла:
private static String getInputText(Scanner scanner) {
        StringBuilder allText = new StringBuilder();
        System.out.println("Для выхода из ввода введите exit");
        while (true) {
            String line = scanner.nextLine();
            if ("exit".equals(line)) {
                break;
            }
            allText.append(line).append("\n"); // Добавляем строку к общему тексту
        }
        return allText.substring(0, allText.length());
    }private static String getInputText(Scanner scanner) {
        StringBuilder allText = new StringBuilder();
        System.out.println("Для выхода из ввода введите exit");
        while (true) {
            String line = scanner.nextLine();
            if ("exit".equals(line)) {
                break;
            }
            allText.append(line).append("\n"); // Добавляем строку к общему тексту
        }
        return allText.substring(0, allText.length());
    }

1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
1
Введите директорию:
homework19/src/data
Введите имя файла:
example.txt
Введите текст файла:
Для выхода из ввода введите exit
Простой текс
exit
Перезаписать файл: y/n
y
Размер файла: 24 Время загрузки: 4
1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
2
Введите директорию:
homework19/src/data
Введите имя файла:
example
Ошибка чтения или ввода: homework19\src\data\example (Не удается найти указанный файл)
1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
2
Введите директорию:
homework19/src/data
Введите имя файла:
example.txt
Текст из файла:
Простой текс

1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
3
Выход из программы

Process finished with exit code 0
```