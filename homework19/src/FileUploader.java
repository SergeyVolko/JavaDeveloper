import java.io.*;
import java.util.Scanner;

public class FileUploader {

    public  FileProperties saveFile(String directory, String fileName, String text) throws IOException, EmptyArgumentException {
        validateDataInputFail(directory, fileName);
        File file = new File(directory, fileName);
        long fileSize = 0L;
        long timeWrite = 0L;
        boolean isExist = file.exists();
        if (isExist) {
            fileSize = file.length();
        }
        FileProperties fileProperties = new FileProperties(timeWrite, fileSize);
        if (!isExist || isRewritingFile(file)) {
            long startTime = System.currentTimeMillis();
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(text);
            }
            timeWrite = System.currentTimeMillis() - startTime;
            fileSize = file.length();
            fileProperties = new FileProperties(timeWrite, fileSize);
        }
        return fileProperties;
    }

    public String readFile(String directory, String fileName) throws IOException, EmptyArgumentException {
        validateDataInputFail(directory, fileName);
        File file = new File(directory, fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("Такой файл отсутствует");
        }
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }

    private boolean isRewritingFile(File file) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Перезаписать файл: y/n");
        String answer = null;
        int count = 0;
        while (count < 3) {
            answer = scanner.nextLine();
            if ("y".equals(answer) || "n".equals(answer)) {
                break;
            }
            System.out.println("Не верный ввод. Введите: y/n");
            count++;
            if (count == 3) {
                answer = "n";
            }
        }
        return "y".equals(answer);

    }

    private void validateDataInputFail(String directory, String fileName) throws EmptyArgumentException {
        if (directory.isEmpty() || fileName.isEmpty()) {
            throw new EmptyArgumentException("Переданы пустые значения");
        }
    }

}
