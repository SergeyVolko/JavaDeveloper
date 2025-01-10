package manager.exam.service;

import manager.exam.config.ExamManagerConfig;
import manager.exam.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ExamManagerConfig.class)
class QuestionParserTest {
    @Autowired
    private QuestionParser questionParser;

    @Test
    void textToParseQuestion() {
        Question expect = new Question(1, "A");
        String text = "1,A";
        Question actual = questionParser.textToParseQuestion(text);
        assertEquals(expect, actual);
    }
}