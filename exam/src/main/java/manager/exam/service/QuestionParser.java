package manager.exam.service;

import manager.exam.model.Question;
import org.springframework.stereotype.Service;

@Service
public class QuestionParser {

    public Question textToParseQuestion(String text) {
        String[] args = text.split(",");
        int number = Integer.parseInt(args[0]);
        return new Question(number, args[1]);
    }
}
