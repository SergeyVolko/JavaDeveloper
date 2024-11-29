# Домашнее задание №16
## Stream api, lambda, optional
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