package manager.exam.service;

import manager.exam.config.ExamManagerConfig;
import manager.exam.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ExamManagerConfig.class)
class ReaderCSVTest {
    private static final String CORRECT_ANSWERS_FILE = "correct-answer.csv";
    @Autowired
    private ReaderCSV readerCSV;

    @Test
    void readFromFile() throws IOException {
        Set<Question> expect = Set.of(
                new Question(1, "A"),
                new Question(2, "C")
        );
        Path path = new ClassPathResource(CORRECT_ANSWERS_FILE).getFile().toPath();
        Set<Question> actual = readerCSV.readFromFile(path);
        assertEquals(expect, actual);
    }
}