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
