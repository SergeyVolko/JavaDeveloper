package manager.exam.config;

import manager.exam.service.QuestionNumberScores;
import manager.exam.service.QuestionParser;
import manager.exam.service.ReaderCSV;
import manager.exam.service.ResultsProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PropertiesConfiguration.class)
public class ExamManagerConfig {

    @Bean
    public QuestionNumberScores questionNumberScores() {
        return new QuestionNumberScores();
    }

    @Bean
    public QuestionParser questionParser() {
        return new QuestionParser();
    }

    @Bean
    public ReaderCSV readerCSV() {
        return new ReaderCSV(questionParser());
    }

    @Bean
    public ResultsProcessor resultsProcessor() {
        return new ResultsProcessor(
                questionNumberScores(),
                readerCSV()
        );
    }
}
