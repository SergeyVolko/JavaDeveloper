package manager.exam.service;

import manager.exam.config.ExamManagerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ExamManagerConfig.class)
class ResultsProcessorTest {
    private static final String CORRECT_ANSWERS_FILE = "correct-answer.csv";
    private static final String STUDENT_ANSWERS_FILE = "student-answer.csv";

    @Autowired
    private ResultsProcessor resultsProcessor;

    @Test
    public void testGetTestResults() throws IOException {
        int expect = 4;
        assertEquals(expect, resultsProcessor.getTestResults(CORRECT_ANSWERS_FILE, STUDENT_ANSWERS_FILE));
    }

}