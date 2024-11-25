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
