# Домашнее задание №9
## Обработка исключений
Исходный код класса Main:
```java
import exception.AccessDeniedException;
import exception.InsufficientAmountException;

public class Main {
    public static String accountName = "MyAcc";
    public static int amount = 10000;

    public static void main(String[] args) throws InsufficientAmountException {
        System.out.println(deduct("MyAcc", 900));
    }

    public static int deduct(String accountToProcess, int amtToCacheOut) throws InsufficientAmountException {
        if (!accountName.equals(accountToProcess)){
            throw new AccessDeniedException("Provided account doesn't match the target one");
        }
        if (amount < amtToCacheOut){
            throw new InsufficientAmountException("Not enough money to withdraw " + amtToCacheOut);
        }
        amount = amount - amtToCacheOut;
        return amount;
    }


}
```
Исходный код класса AccessDeniedException:
```java
package exception;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException() {
    }

    public AccessDeniedException(String message) {
        super(message);
    }
}
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