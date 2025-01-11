package manager.exam;

import manager.exam.config.ExamManagerConfig;
import manager.exam.service.ResultsProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class ExamApplicationMain {
    private static final String CORRECT_ANSWERS_FILE = "correct-answer.csv";
    private static final String STUDENT_ANSWERS_FILE = "student-answer.csv";

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExamManagerConfig.class);
        ResultsProcessor resultsProcessor = applicationContext.getBean(ResultsProcessor.class);
        System.out.println("Total score: " + resultsProcessor.getTestResults(CORRECT_ANSWERS_FILE, STUDENT_ANSWERS_FILE));
    }
}
