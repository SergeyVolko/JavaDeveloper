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
