# Домашнее задание №7
## Классы и объекты: продвинутый уровень
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