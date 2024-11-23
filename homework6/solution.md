# Домашнее задание №6
## Классы и объекты: начальный уровень
### Задание №1
Исходный код класса Human:
```java
package task1;

public abstract class Human {
    private int age;
    private String name;
    private boolean gender;

    public Human(int age, String name, boolean gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public abstract void doTheWork();
}
```
Исходный код класса Student:
```java
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
```
Исходный код класса AssociateProfessor:
```java
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
```
### Задание №2
Скриншот компиляции и работы программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework6/src/screen/%D0%94%D0%97%E2%84%966.png?raw=true)<br><br>
Исходный код класса Main:
```java
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
```
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=50138:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework6 task1.Main
My specialization is Economy
My academic degree is PhD
I'm in college
I teach students

Process finished with exit code 0
```