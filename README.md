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