# Домашнее задание №14
## Коллекции: ArrayList и LinkedList
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