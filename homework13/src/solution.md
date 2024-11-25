# Домашнее задание №13
## Обзор коллекций в Java
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