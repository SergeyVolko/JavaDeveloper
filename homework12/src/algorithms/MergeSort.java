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
