package org.db.students;

import java.util.Scanner;

public class Main {
    private static final StudentCommandHandler STUDENT_COMMAND_HANDLER = new StudentCommandHandler();


    public static void main(String[] args) {
        while (true) {
            printMessage();
            Command command = readCommand();
            if (command.getAction().equals(Action.EXIT)) {
                return;
            }
            if (command.getAction().equals(Action.ERROR)) {
                continue;
            }
            STUDENT_COMMAND_HANDLER.processCommand(command);
        }

    }

    private static Command readCommand() {
        Scanner scanner = new Scanner(System.in);
        try {
            String code = scanner.nextLine();
            Integer actionCode = Integer.parseInt(code);
            Action action = Action.fromCode(actionCode);
            if (action.isRequiredAdditionalData()) {
                String data = scanner.nextLine();
                DataValidator.dataValidate(action, data);
                return new Command(action, data);
            } else {
                return new Command(action);
            }
        } catch (DataValidateException ex) {
            System.out.println("Проблема с шаблоном ввода. " + ex.getMessage());
            return new Command(Action.ERROR);
        } catch (Exception ex) {
            System.out.println("Проблема обработки ввода. " + ex.getMessage());
            return new Command(Action.ERROR);
        }
    }

    private static void printMessage() {
        System.out.println("-".repeat(50));
        System.out.println("0. Выход");
        System.out.println("1. Создание данных");
        System.out.println("2. Обновление данных");
        System.out.println("3. Удаление данных");
        System.out.println("4. Вывод статистики по курсам");
        System.out.println("5. Вывод статистики по городам");
        System.out.println("6. Поиск по фамилии");
        System.out.println("-".repeat(50));
    }
}
