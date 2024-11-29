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
