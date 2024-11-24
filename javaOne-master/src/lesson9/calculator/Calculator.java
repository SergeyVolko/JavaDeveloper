package lesson9.calculator;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        double[] results = new double[10];
        double first = 0L;
        double second = 0L;
        int count = 0;
        for (int i = 0; i < results.length; i++) {
            System.out.print("Введите 2 числа ");
            String exit = reader.next();
            if ("выход".equals(exit)) {
                count = i;
                System.out.println("Вы вышли из программы");
                break;
            }

            try {
                first = Double.parseDouble(exit);
                second = Double.parseDouble(reader.next());
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Не правильный ввод попробуйте еще раз");
            }

            System.out.print("Введите оператор: (+, -, *, /): ");
            char operator = reader.next().charAt(0);

            double result = 0.0;

            switch (operator) {
                case '+':
                    result = first + second;
                    break;

                case '-':
                    result = first - second;
                    break;

                case '*':
                    result = first * second;
                    break;

                case '/':
                    result = first / second;
                    break;

                default:
                    System.out.println("Введите корректный оператор");
                    continue;
            }
            System.out.printf("%.1f %c %.1f = %.1f\n", first, operator, second, result);
            results[i] = result;
        }
        for (int i = 0; i < count; i++) {
            System.out.printf("%.1f" + ((i < count) ? " " : ""), results[i]);
        }
    }
}

/*
 *     ДЗ
 *     1. добавьте массив для сохранения результатов размерностью 10
 *     если результатов стало больше мы завершаем работы, информируя пользователя и распечатывая результаты
 *
 *     2. поместите код в цикл для возможности использования без постоянного запуска программы.
 *     Для выхода пусть буду слова "выход"
 *     T.е. пользователь ввел выход - мы просто выходим, сохраняя результат в массиве результатов и выводим массив на консоль.
 *
 *
 */

