package org.db.students;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private static final Map<Action, String> ACTION_REGEX = Map.of(
            Action.CREATE, "^[а-яА-ЯёЁa-zA-Z]+,[а-яА-ЯёЁa-zA-Z]+,[а-яА-ЯёЁa-zA-Z]+,[а-яА-ЯёЁa-zA-Z]+,\\d+$",
            Action.UPDATE, "^\\d+,[а-яА-ЯёЁa-zA-Z]+,[а-яА-ЯёЁa-zA-Z]+,[а-яА-ЯёЁa-zA-Z]+,[а-яА-ЯёЁa-zA-Z]+,\\d+$",
            Action.DELETE, "\\d+",
            Action.SEARCH, "^(|([а-яА-ЯёЁa-zA-Z]+)|([а-яА-ЯёЁa-zA-Z]+,[а-яА-ЯёЁa-zA-Z]+))$"
    );

    public static void dataValidate(Action action, String data) throws DataValidateException {
        Pattern pattern = Pattern.compile(ACTION_REGEX.get(action));
        Matcher matcher = pattern.matcher(data);
        if (!matcher.matches()) {
            throw new DataValidateException(String.format("Для действия %s введенные данные не соответствуют шаблону",
                    action));
        }
        if (Action.SEARCH.equals(action)) {
            String[] surname = data.split(",");
            if (surname.length == 2 && surname[0].compareTo(surname[1]) > 0) {
                throw new DataValidateException(String.format("Для действия %s введенные данные не соответствуют" +
                                " правильному порядку ввода", action));
            }
        }
    }
}
