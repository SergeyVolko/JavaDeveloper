# Домашнее задание №9
## Работа с массивами
Скриншот сборки программы:
![Скриншот1](https://github.com/SergeyVolko/JavaDeveloper/blob/master/homework2/src/screen/%D0%94%D0%B7%E2%84%962.png?raw=true)<br><br>
Исходный код класса `DefaultCustomArrayList`:
```java
package com.edu;

import java.util.*;
import java.util.stream.IntStream;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 5;
    private static final int MULTIPLE_CAPACITY = 2;
    private Object[] data;
    private int size;
    private final int maxCapacity;
    int modCount = 0;

    public DefaultCustomArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.maxCapacity = Integer.MAX_VALUE;
    }

    public DefaultCustomArrayList(int maxCapacity) {
        this.data = new Object[DEFAULT_CAPACITY];
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean add(E element) {
        if (size == maxCapacity) {
            return false;
        }
        if (data.length == size) {
            data = Arrays.copyOf(data, data.length * MULTIPLE_CAPACITY);
        }
        data[size++] = element;
        return true;
    }

    @Override
    public boolean remove(E element) {
        int index = getIndex(element);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    private void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
    }

    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean contains(E element) {
        return getIndex(element) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private int getIndex(E element) {
        return IntStream.range(0, data.length)
                .filter(i -> Objects.equals(element, data[i]))
                .findFirst()
                .orElse(-1);
    }

    private class Itr implements Iterator<E> {
        int cursor;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            checkForComodification();
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            Object[] data = DefaultCustomArrayList.this.data;
            return (E) data[cursor++];
        }

        private void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
```
Исходный код класса AccessDeniedException:
```text
Microsoft Windows [Version 10.0.19045.5131]
(c) Microsoft Corporation. All rights reserved.

C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main>mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< com.example:custom-arraylist >--------------------
[INFO] Building custom-arraylist 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ custom-arraylist ---
[INFO] Deleting C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ custom-arraylist ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ custom-arraylist ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\target\classes
[WARNING] /C:/Users/Lenovo/IdeaProjects/JavaDeveloperProductStar/arrays-homework-main/src/main/java/com/edu/DefaultCustomArrayList.java: C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\src\main\java\com\edu\DefaultCustomArrayList.java uses unchecked or unsafe operations.
[WARNING] /C:/Users/Lenovo/IdeaProjects/JavaDeveloperProductStar/arrays-homework-main/src/main/java/com/edu/DefaultCustomArrayList.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ custom-arraylist ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ custom-arraylist ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\target\test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:3.0.0-M5:test (default-test) @ custom-arraylist ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running DefaultCustomArrayListTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.264 s - in DefaultCustomArrayListTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ custom-arraylist ---
[INFO] Building jar: C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\target\custom-arraylist-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ custom-arraylist ---
[INFO] Installing C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\target\custom-arraylist-1.0-SNAPSHOT.jar to C:\Users\Lenovo\.m2\repository\com\example\custom-arraylist\1.0-SNAPSHOT\custom-arraylist-1.0-SNAPSHOT.jar
[INFO] Installing C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main\pom.xml to C:\Users\Lenovo\.m2\repository\com\example\custom-arraylist\1.0-SNAPSHOT\custom-arraylist-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.485 s
[INFO] Finished at: 2024-11-24T08:17:17+03:00
[INFO] ------------------------------------------------------------------------

C:\Users\Lenovo\IdeaProjects\JavaDeveloperProductStar\arrays-homework-main>
```
Исходный код класса InsufficientAmountException:
```java
package exception;

public class InsufficientAmountException extends Exception {
    public InsufficientAmountException() {
    }

    public InsufficientAmountException(String message) {
        super(message);
    }
}
```