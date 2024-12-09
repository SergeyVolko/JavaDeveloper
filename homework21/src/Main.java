import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    private static final String fileName = "C:\\Users\\Lenovo\\IdeaProjects\\JavaDeveloperProductStar\\homework21\\src\\file.txt";

    public static void main(String[] args) {
        write();
        read();
    }

    private static void write() {
        Path filePath = Paths.get(fileName);

        // Создание файла и получение канала для записи
        try (FileChannel fileChannel = FileChannel.open(
                filePath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE
        )) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    break;
                }
                buffer.clear();
                buffer.put(input.getBytes());
                buffer.flip();
                while (buffer.hasRemaining()) {
                    fileChannel.write(buffer);
                }
                buffer.clear();
            }
        } catch (IOException e) {
            // не забудем про ошибку
            e.printStackTrace();
        }
    }

    private static void read() {
        Path filePath = Paths.get(fileName);
        try(FileChannel fileChannel = FileChannel.open(
                filePath,
                StandardOpenOption.READ
        )) {
            long fileSize = fileChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            fileChannel.read(buffer);
            buffer.flip();
            System.out.println(new String(buffer.array()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
