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