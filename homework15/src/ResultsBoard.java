import java.util.List;
import java.util.TreeSet;

public class ResultsBoard {
    private final TreeSet<Student> students = new TreeSet<>();

    public void addStudent(String name, Float score) {
        students.add(new Student(name, score));
    }

    public List<String> top3() {
        return students.descendingSet().stream()
                .limit(3)
                .map(Student::getName)
                .toList();
    }

    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("Petr", 4.5f);
        resultsBoard.addStudent("Ivan", 3.2f);
        resultsBoard.addStudent("Igor", 2.4f);
        resultsBoard.addStudent("Sveta", 4.9f);
        resultsBoard.addStudent("Andrew", 3.1f);

        System.out.println(resultsBoard.students);
        resultsBoard.students.last();
        System.out.println(resultsBoard.students);
        System.out.println(resultsBoard.top3());

        resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("Ivan", 3.0f);
        resultsBoard.addStudent("Maria", 4.0f);
        resultsBoard.addStudent("Oleg", 4.0f);
        System.out.println(resultsBoard.top3());
    }
}
