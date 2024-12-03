# Домашнее задание №19
## Работа с файлами. Адаптер и декоратор
Вывод в консоль:
```
C:\Users\Lenovo\.jdks\corretto-17.0.13\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJIdea2024.1\lib\idea_rt.jar=52299:C:\Program Files\JetBrains\IntelliJIdea2024.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\out\production\homework19 Loader
1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
1
Введите директорию:
C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\homework19\src\data
Введите имя файла:
example.txt
Введите текст файла:
Для выхода из ввода введите exit
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
exit
Размер файла: 1041 Время загрузки: 4
1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
2
Введите директорию:
homework19/src/data
Введите имя файла:
example.txt
Текст из файла:
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
    }private static String getInputText(Scanner scanner) {
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

1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
1
Введите директорию:
homework19/src/data
Введите имя файла:
example.txt
Введите текст файла:
Для выхода из ввода введите exit
Простой текс
exit
Перезаписать файл: y/n
y
Размер файла: 24 Время загрузки: 4
1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
2
Введите директорию:
homework19/src/data
Введите имя файла:
example
Ошибка чтения или ввода: homework19\src\data\example (Не удается найти указанный файл)
1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
2
Введите директорию:
homework19/src/data
Введите имя файла:
example.txt
Текст из файла:
Простой текс

1 - Введите директорию, имя файла и текст для записи в файл
2 - Введите директорию и имя файла для чтения из файла
3 - Введите для выхода из программы
--------------------------------------------------
3
Выход из программы

Process finished with exit code 0
```