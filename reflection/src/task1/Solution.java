package task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        method1();
        method2();

    }

    public static void method1() throws NoSuchFieldException, IllegalAccessException {
        PrivateClass privateClass = new PrivateClass("Значение приватного поля");
        Field privateStringField = PrivateClass.class.getDeclaredField("mPrivateString");
        privateStringField.setAccessible(true);
        String fieldValue = (String) privateStringField.get(privateClass);
        System.out.println("значение приватного поля = " + fieldValue);
    }

    public static void method2() throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        PrivateClass privateClass = new PrivateClass("Какое-то значение");
        Method privateStringMethod = PrivateClass.class.getDeclaredMethod("getPrivateString", null);
        privateStringMethod.setAccessible(true);
        String returnValue = (String) privateStringMethod.invoke(privateClass, null);
        System.out.println(returnValue);
    }
}
