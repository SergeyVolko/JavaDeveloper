# Домашнее задание №8
## Методы и поля классов
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