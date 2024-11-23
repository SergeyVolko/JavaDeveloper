package task1;

public class AssociateProfessor extends Human {
    private String academicDegree;

    public AssociateProfessor(int age, String name, boolean gender, String academicDegree) {
        super(age, name, gender);
        this.academicDegree = academicDegree;
    }

    public void tellAcademicDegree() {
        System.out.println("My academic degree is " + academicDegree);
    }

    @Override
    public void doTheWork() {
        System.out.println("I teach students");
    }
}
