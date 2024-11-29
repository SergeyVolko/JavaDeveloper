package org.db.students;

public class StudentCommandHandler {

    public void processCommand(Command command) {
        System.out.printf("Обработка команды. Действие: %s, данные: %s\n",
                command.getAction().name(), command.getData());
    }
}
