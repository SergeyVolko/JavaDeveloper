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
