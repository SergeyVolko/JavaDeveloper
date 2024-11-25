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
