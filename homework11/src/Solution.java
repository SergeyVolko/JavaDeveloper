public class Solution {
    private static final String REGEX_E = "[^(е|e)]";
    private static final String REGEX_PHONE = "^\\+\\d{1,4}\\(\\d{1,4}\\)\\d{1,4}-\\d{1,4}-\\d{1,4}$";
    private static final String REGEX_REMOVE_LETTER_AND_SPACES = "[a-zA-Zа-я\\s]+";

    public static void main(String[] args) {
        System.out.println(countTheNumberOfLettersE("dgedje"));
        System.out.println(countTheNumberOfLettersE("Домашнее задание"));
        System.out.println(validatePhone("+7(746)982-23-45"));
        System.out.println(validatePhone("+7(746)98223-45"));
        System.out.println(removeLetterAndSpace("jrf jfr6jr jака5f"));
    }

    public static int countTheNumberOfLettersE(String text) {
        return text.replaceAll(REGEX_E, "").length();
    }

    public static boolean validatePhone(String phone) {
        return phone.matches(REGEX_PHONE);
    }

    public static String removeLetterAndSpace(String text) {
        return text.replaceAll(REGEX_REMOVE_LETTER_AND_SPACES, "");
    }
}
