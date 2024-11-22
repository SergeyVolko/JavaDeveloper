import java.util.Arrays;

public class WorkShop {
    public static void main(String[] args) {
        Friend[] myFriends = {
            new Friend("Вася", 25, true, 4.56f),
            new Friend("Лиза", 23, false, 3.22f),
            new Friend("Петя", 20, true, 2.11f),
            new Friend("Саша", 21, false, 6.34f),
            new Friend("Иван", 29, true, 5.32f),
            new Friend("Петр", 30, false, 9.36f)
        };

        System.out.println(Arrays.toString(myFriends));
    }
}
