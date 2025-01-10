package manager.exam.service;

import manager.exam.model.Question;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

@Service
public class ResultsProcessor {
    private static final String CORRECT_ANSWERS_FILE = "correct-answer.csv";
    private static final String STUDENT_ANSWERS_FILE = "student-answer.csv";
    private final QuestionNumberScores questionNumberScores;
    private final ReaderCSV readerCSV;

    public ResultsProcessor(QuestionNumberScores questionNumberScores, ReaderCSV readerCSV) {
        this.questionNumberScores = questionNumberScores;
        this.readerCSV = readerCSV;
    }

    public int getTestResults() throws IOException {
        Path correctFileQuestion = new ClassPathResource(CORRECT_ANSWERS_FILE).getFile().toPath();
        Path answerFileQuestion = new ClassPathResource(STUDENT_ANSWERS_FILE).getFile().toPath();
        Set<Question> correctAnswer = readerCSV.readFromFile(correctFileQuestion);
        Set<Question> studentAnswer = readerCSV.readFromFile(answerFileQuestion);
        return studentAnswer.stream()
                .filter(correctAnswer::contains)
                .mapToInt(e -> questionNumberScores.getScore(e.number()))
                .sum();
    }
}
