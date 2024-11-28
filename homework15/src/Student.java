public class Student implements Comparable<Student> {
    private String name;
    private float score;

    public Student(String name, float score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        int result = Float.compare(score, o.score);
        if (result == 0) {
            result = o.name.compareTo(name);
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("[%s %f]", name, score);
    }
}
