import java.io.IOException;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        FileUploader fileUploader = new FileUploader();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            String answer = scanner.nextLine();
            try {
                if ("1".equals(answer)) {
                    System.out.println("Введите директорию:");
                    String directory = scanner.nextLine();
                    System.out.println("Введите имя файла:");
                    String fileName = scanner.nextLine();
                    System.out.println("Введите текст файла:");
                    String text = getInputText(scanner);
                    FileProperties fileProperties = fileUploader.saveFile(directory, fileName, text);
                    System.out.printf("Размер файла: %d Время загрузки: %d\n", fileProperties.getFileSize(),
                            fileProperties.getTimeWrite());
                } else if ("2".equals(answer)) {
                    System.out.println("Введите директорию:");
                    String directory = scanner.nextLine();
                    System.out.println("Введите имя файла:");
                    String fileName = scanner.nextLine();
                    String text = fileUploader.readFile(directory, fileName);
                    System.out.println("Текст из файла:");
                    System.out.println(text);
                } else if ("3".equals(answer)) {
                    System.out.println("Выход из программы");
                    break;
                } else {
                    System.out.println("Неизвестная команда. Попробуйте еще раз.");
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения или ввода: " + e.getMessage());
            } catch (EmptyArgumentException e) {
                e.getStackTrace();
            }

        }
    }

    private static void menu() {
        System.out.println("1 - Введите директорию, имя файла и текст для записи в файл");
        System.out.println("2 - Введите директорию и имя файла для чтения из файла");
        System.out.println("3 - Введите для выхода из программы");
        System.out.println("-".repeat(50));
    }

    private static String getInputText(Scanner scanner) {
        StringBuilder allText = new StringBuilder();
        System.out.println("Для выхода из ввода введите exit");
        while (true) {
            String line = scanner.nextLine();
            if ("exit".equals(line)) {
                break;
            }
            allText.append(line).append("\n"); // Добавляем строку к общему тексту
        }
        return allText.substring(0, allText.length());
    }

}
