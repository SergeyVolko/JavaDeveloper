package manager.exam.service;

import manager.exam.config.ExamManagerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ExamManagerConfig.class)
class QuestionNumberScoresTest {
    @Autowired
    private QuestionNumberScores questionNumberScores;

    @Test
    void getScore() {
        assertEquals(1, questionNumberScores.getScore(1));
        assertEquals(1, questionNumberScores.getScore(2));
        assertEquals(1, questionNumberScores.getScore(3));
        assertEquals(1, questionNumberScores.getScore(4));
        assertEquals(2, questionNumberScores.getScore(5));
        assertEquals(2, questionNumberScores.getScore(6));
        assertEquals(2, questionNumberScores.getScore(7));
        assertEquals(2, questionNumberScores.getScore(8));
        assertEquals(3, questionNumberScores.getScore(9));
        assertEquals(3, questionNumberScores.getScore(10));
    }
}