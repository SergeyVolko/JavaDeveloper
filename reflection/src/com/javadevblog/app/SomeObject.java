package com.javadevblog.app;

import java.lang.reflect.*;
import java.util.Arrays;

public class SomeObject extends ParentObject implements SomeInterface {
    public int i;
    private String name;

    public SomeObject(int i) {
        this.i = i;
    }

    public SomeObject() {
        this.i = 5;
    }

    public SomeObject(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class mClassObject = SomeObject.class;
        mClassObject = Class.forName("com.javadevblog.app.SomeObject");


        String fullClassName = mClassObject.getName();
        System.out.println(fullClassName);

        String justClassName = mClassObject.getSimpleName();
        System.out.println(justClassName);

        int classModifiers = mClassObject.getModifiers();
        System.out.println(classModifiers);

        System.out.println(Modifier.isAbstract(classModifiers));
        System.out.println(Modifier.isFinal(classModifiers));
        System.out.println(Modifier.isInterface(classModifiers));
        System.out.println(Modifier.isNative(classModifiers));
        System.out.println(Modifier.isPrivate(classModifiers));
        System.out.println(Modifier.isProtected(classModifiers));
        System.out.println(Modifier.isPublic(classModifiers));
        System.out.println(Modifier.isStatic(classModifiers));
        System.out.println(Modifier.isStrict(classModifiers));
        System.out.println(Modifier.isSynchronized(classModifiers));
        System.out.println(Modifier.isTransient(classModifiers));
        System.out.println(Modifier.isVolatile(classModifiers));

        Package packageClass = mClassObject.getPackage();
        System.out.println(packageClass);

        Class superclass = mClassObject.getSuperclass();
        System.out.println(superclass);

        Class[] interfaces = mClassObject.getInterfaces();
        System.out.println(interfaces[0]);

        Constructor[] constructors = mClassObject.getConstructors();
        System.out.println(constructors.length);
        Arrays.stream(constructors).forEach(c -> System.out.println(c.getName() + " : " + c.getParameterCount()));
        System.out.println();


        Constructor constructor = mClassObject.getConstructor(new Class[]{String.class});
        System.out.println(constructor);
        Class[] parameterTypes = constructor.getParameterTypes();
        System.out.println(parameterTypes[0]);

        System.out.println();

        // получаем конструктор, который принимает String в качестве параметра
        constructor = SomeObject.class.getConstructor(String.class);
        SomeObject myObject = (SomeObject)
                constructor.newInstance("здесь какой-то строковый аргумент");
        System.out.println(myObject);
        System.out.println();

        Field[] fields = mClassObject.getFields();
        System.out.println(fields.length);
        Field field = mClassObject.getField("i");
        System.out.println(field);
        String fieldName = field.getName();
        System.out.println(fieldName);
        Object fieldType = field.getType();
        System.out.println(fieldType);

        SomeObject instance = new SomeObject();
        Object value = field.get(instance);
        System.out.println(value);
        field.set(instance, 123);
        System.out.println(instance);
        System.out.println();

        Method[] methods = mClassObject.getMethods();
        System.out.println(methods[0]);
        Method method = mClassObject.getMethod("sayHello", new Class[]{String.class});
        System.out.println(method);
        method = mClassObject.getMethod("hello", null);
        System.out.println(method);
        method = mClassObject.getMethod("getName", null);
        System.out.println();

        method = mClassObject.getMethod("sayHello", new Class[]{String.class});
        parameterTypes = method.getParameterTypes();
        System.out.println(parameterTypes[0]);
        System.out.println();

        method = mClassObject.getMethod("getName", null);
        Class returnType = method.getReturnType();
        System.out.println(returnType);

        mClassObject = SomeObject.class;
        method = mClassObject.getDeclaredMethod("sayHello", parameterTypes);
        Object[] param = {"Обычный текст."};
        instance = new SomeObject();
        method.invoke(instance, param);
        System.out.println();

        method = mClassObject.getDeclaredMethod("sum", new Class[]{int.class, int.class});
        System.out.println(method);
        param = new Object[]{1, 2};
        int result  = (Integer) method.invoke(null, param);
        System.out.println(result);
        System.out.println();

        printGettersOrSetters(mClassObject);
    }

    public static void printGettersOrSetters(Class aClass){
        Method[] methods = aClass.getMethods();

        for(Method method : methods){
            if(isGetter(method)) System.out.println("getter: " + method);
            if(isSetter(method)) System.out.println("setter: " + method);
        }
    }

    public static boolean isGetter(Method method){
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }

    public static boolean isSetter(Method method){
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        return true;
    }

    @Override
    public void hello() {

    }

    public void sayHello(String text) {
        System.out.println("Всем привет!!!!" + text);
    }

    public int getI() {
        return i;
    }

    public String getName() {
        return name;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "SomeObject{" +
                "i=" + i +
                ", name='" + name + '\'' +
                '}';
    }
}
