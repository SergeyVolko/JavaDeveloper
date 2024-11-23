package task1;

public class Student extends Human {
    private String specialization;

    public Student(int age, String name, boolean gender, String specialization) {
        super(age, name, gender);
        this.specialization = specialization;
    }

    public void tellSpecialization() {
        System.out.println("My specialization is " + specialization);
    }

    @Override
    public void doTheWork() {
        System.out.println("I'm in college");
    }


}
