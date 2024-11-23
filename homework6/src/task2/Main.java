package task2;

import task1.AssociateProfessor;
import task1.Human;
import task1.Student;

public class Main {

    public static void main(String[] args) {
        Student student = new Student(20, "Вася", true, "Economy");
        AssociateProfessor professor = new AssociateProfessor(50, "Петр", true, "PhD");
        student.tellSpecialization();
        professor.tellAcademicDegree();
        Human[] humans = {student, professor};
        humans[0].doTheWork();
        humans[1].doTheWork();
    }
}
