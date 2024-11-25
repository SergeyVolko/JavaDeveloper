package algorithms;

public abstract class SortingAlgorithm {
    private String nameAlgorithm;
    private long time;

    public SortingAlgorithm(String nameAlgorithm) {
        this.nameAlgorithm = nameAlgorithm;
    }

    public abstract void sort(int[] array);

    public String getNameAlgorithm() {
        return nameAlgorithm;
    }

    public long getTime() {
        return time;
    }

    public void sortArrayWithSetTime(int[] array) {
        long startTime = System.currentTimeMillis();
        sort(array);
        this.time = System.currentTimeMillis() - startTime;
    }
}
