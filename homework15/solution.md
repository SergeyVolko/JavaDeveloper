# Домашнее задание №15
## Коллекции: TreeMap, TreeSet
Исходный код класса `Student`:
```java
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

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Float.compare(score, o.score);
    }

    @Override
    public String toString() {
        return String.format("[%s %f]", name, score);
    }
}
```
Исходный код класса `ResultsBoard`:
```java
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
    }
}
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50400:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework15 ResultsBoard
[[Igor 2,400000], [Andrew 3,100000], [Ivan 3,200000], [Petr 4,500000], [Sveta 4,900000]]
[[Igor 2,400000], [Andrew 3,100000], [Ivan 3,200000], [Petr 4,500000], [Sveta 4,900000]]
[Sveta, Petr, Ivan]

Process finished with exit code 0
```