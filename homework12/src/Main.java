import algorithms.*;

public class Main {
    public static void main(String[] args) {
        SortingAlgorithm[] algorithms = {
                new BubbleSort("Пузырьковая сортировка"),
                new InsertSort("Сортировка вставками"),
                new SelectionSort("Сортировка выбором"),
                new MergeSort("Сортировка слиянием"),
                new JavaSort("Сортировка Java")
        };

        TemporalSortingTester tester = new TemporalSortingTester(algorithms, 100000, TypeGenerated.UNIQUE);
        tester.showResult();
    }
}
