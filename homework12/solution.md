# Домашнее задание №12
## Знакомство с алгоритмами
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