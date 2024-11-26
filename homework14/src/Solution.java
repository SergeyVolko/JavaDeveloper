import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 5));
        System.out.println("Исходный массив: " + arr);
        IntStream.rangeClosed(0, arr.size() + 1)
                .forEach((e) -> System.out.println(e +": " + getRollingAverage(arr, e)));
    }

    public static List<Double> getRollingAverage(ArrayList<Integer> arr, int k) {
        List<Double> list = new ArrayList<>();
        int size = arr.size();
        if (k <= 0) {
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
}
