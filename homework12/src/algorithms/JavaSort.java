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
