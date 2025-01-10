package manager.exam;

import manager.exam.config.ExamManagerConfig;
import manager.exam.service.ResultsProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class ExamApplicationMain {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExamManagerConfig.class);
        ResultsProcessor resultsProcessor = applicationContext.getBean(ResultsProcessor.class);
        System.out.println("Total score: " + resultsProcessor.getTestResults());
    }
}
