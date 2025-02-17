package org.db.students;

import java.util.Map;

public class StudentCommandHandler {
    private final StudentStorage studentStorage = new StudentStorage();

    public void processCommand(Command command) {
        Action action = command.getAction();
        switch (action) {
            case CREATE -> processCreateDate(command);
            case UPDATE -> processUpdateStudent(command);
            case DELETE -> processDeleteCommand(command);
            case STATS_BY_COURSE -> processStatsByCourseCommand(command);
            case STATS_BY_CITIES -> processStatsByCitiesCommand(command);
            case SEARCH -> processSearchCommand(command);
            default -> System.out.printf("Действие %s не поддерживается", action.name());
        }

        System.out.printf("Обработка команды. Действие: %s, данные: %s\n",
                command.getAction().name(), command.getData());
    }

    private void processSearchCommand(Command command) {
        String surname = command.getData();
        studentStorage.search(surname);
    }

    private void processStatsByCitiesCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCity();
        studentStorage.printMap(data);
    }

    private void processStatsByCourseCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
    }

    private void processCreateDate(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");

        Student student = new Student();
        student.setSurname(dataArray[0]);
        student.setName(dataArray[1]);
        student.setCourse(dataArray[2]);
        student.setCity(dataArray[3]);
        student.setAge(Integer.parseInt(dataArray[4]));

        studentStorage.createStudent(student);
        studentStorage.printAll();
    }

    public void processUpdateStudent(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");
        Long id = Long.parseLong(dataArray[0]);

        Student student = new Student();
        student.setSurname(dataArray[1]);
        student.setName(dataArray[2]);
        student.setCourse(dataArray[3]);
        student.setCity(dataArray[4]);
        student.setAge(Integer.parseInt(dataArray[5]));

        studentStorage.updateStudent(id, student);
        studentStorage.printAll();
    }

    public void processDeleteCommand(Command command) {
        Long id = Long.parseLong(command.getData());
        studentStorage.deleteStudent(id);
        studentStorage.printAll();
    }
}
