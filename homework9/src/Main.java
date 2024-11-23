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
