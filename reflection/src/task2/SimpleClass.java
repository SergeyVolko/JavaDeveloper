package task2;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

@Reflectable(name="reflectable",  value = "какие-то метаданные")
public class SimpleClass {

    @Reflectable(name="reflectable",  value = "какие-то метаданные")
    public String mField = null;

    private List<String> simpleList = new ArrayList<>();

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException,
            ClassNotFoundException {
        method1();
        System.out.println();
        method2();
        System.out.println();
        method3();
        System.out.println();
        method4();
        System.out.println();
        method5();
        System.out.println();
        method6();
        System.out.println();
        method7();
        System.out.println();
        method8();
        System.out.println();
        method9();
        System.out.println();
        method10();
        System.out.println();
        method11();
    }

    public static void method1() {
        Class aClass = SimpleClass.class;
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Reflectable) {
                Reflectable mAnnotation = (Reflectable) annotation;
                System.out.println("name: " + mAnnotation.name());
                System.out.println("value: " + mAnnotation.value());
            }
        }
    }

    public static void method2() {
        Class aClass = SimpleClass.class;
        Reflectable annotation = (Reflectable) aClass.getAnnotation(Reflectable.class);
        System.out.println("name: " + annotation.name());
        System.out.println("value: " + annotation.value());
    }

    public static void method3() throws NoSuchMethodException {
        Method method = SimpleClass.class.getMethod("sayHello", null);
        Annotation[] annotations = method.getDeclaredAnnotations();
        for(Annotation annotation : annotations) {
            if(annotation instanceof Reflectable) {
                Reflectable mAnnotation = (Reflectable) annotation;
                System.out.println("name: " + mAnnotation.name());
                System.out.println("value: " + mAnnotation.value());
            }
        }
    }

    public static void method4() throws NoSuchMethodException {
        Method method = SimpleClass.class.getMethod("sayHello", null);
        Reflectable annotation = (Reflectable) method.getAnnotation(Reflectable.class);
        System.out.println("name: " + annotation.name());
        System.out.println("value: " + annotation.value());
    }

    public static void method5() throws NoSuchMethodException {
        Method method = SimpleClass.class.getDeclaredMethod("sayBye", String.class);
        Annotation[][] paramAnnotations = method.getParameterAnnotations();
        Class[] paramTypes = method.getParameterTypes();

        int i = 0;
        for (Annotation[] annotations : paramAnnotations) {
            Class paramType = paramTypes[i++];
            for (Annotation annotation : annotations) {
                if (annotation instanceof Reflectable) {
                    Reflectable mAnnotation = (Reflectable) annotation;
                    System.out.println("param: " + paramType.getName());
                    System.out.println("name: " + mAnnotation.name());
                    System.out.println("value: " + mAnnotation.value());
                }
            }
        }
    }

    public static void method6() throws NoSuchFieldException {
        Class mClassObject = SimpleClass.class;
        Field field = mClassObject.getField("mField");
        Reflectable mAnnotation = field.getAnnotation(Reflectable.class);
        System.out.println("name: " + mAnnotation.name());
        System.out.println("value: " + mAnnotation.value());
    }

    public static void method7() throws NoSuchMethodException {
        Method method = SimpleClass.class.getMethod("getList", null);

        Type returnType = method.getGenericReturnType();

        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                Class typeClass = (Class) typeArgument;
                System.out.println("тип: " + typeClass);
            }
        }
    }

    public static void method8() throws NoSuchFieldException {
        Field field = SimpleClass.class.getDeclaredField("simpleList");
        field.setAccessible(true);
        Type genericFieldType = field.getGenericType();

        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) genericFieldType;

            Type[] fieldArgTypes = pType.getActualTypeArguments();

            for (Type fieldArgType : fieldArgTypes){
                Class fieldClass = (Class) fieldArgType;
                System.out.println("тип: " + fieldClass);
            }
        }
    }

    public static void method9() {
        int[] simpleIntArray = (int[]) Array.newInstance(int.class, 2);

        Array.set(simpleIntArray, 0, 443);
        Array.set(simpleIntArray, 1, 554);

        System.out.println("первый элемент массива = " + Array.get(simpleIntArray, 0));
        System.out.println("второй элемент массива = " + Array.get(simpleIntArray, 1));
    }

    public static void method10() throws ClassNotFoundException {
        Class intArrayObject = Class.forName("[I");
        Class stringArrayClassObject = Class.forName("[Ljava.lang.String;");
        String theClassName = "java.lang.String";
        Class arrayClass = getClass(theClassName);
        Class stringArrayClass = Array.newInstance(arrayClass, 0).getClass();
        System.out.println("массив ли это? - " + stringArrayClass.isArray());
    }

    public static void method11() {
        String[] stringArray = new String[2];
        Class arrayClass = stringArray.getClass();
        Class arrayComponentType = arrayClass.getComponentType();
        System.out.println(arrayComponentType);
    }

    public static Class getClass(String className) throws ClassNotFoundException {
        if ("long".equals(className)) {
            return long.class;
        }
        return Class.forName(className);
    }

    @Reflectable(name="reflectable",  value = "какие-то метаданные")
    public void sayHello(){

    }

    public static void sayBye(@Reflectable(name="reflectable", value="какие-то метаданные") String param) {
    }

    public List<String> getList(){
        return this.simpleList;
    }
}
