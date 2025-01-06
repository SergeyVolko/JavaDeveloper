package product.star.spring.service;
/**
 * Ахмадеев Ринас,M,10 km,29:01
 * Коробкина Елена,F,10 km,31:49
 * Плохотников Константин,M,10 km,29:18
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import product.star.spring.config.ResultsProcessorConfig;
import product.star.spring.model.Distance;
import product.star.spring.model.Gender;
import product.star.spring.model.Person;
import product.star.spring.model.Result;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ResultsProcessorConfig.class)
class ResultsReaderTest {


    private final ResultsReader resultsReader;

    @Autowired
    ResultsReaderTest(ResultsReader resultsReader) {
        this.resultsReader = resultsReader;
    }

    @Test
    void readFromFile() throws IOException {
        var filePath = new ClassPathResource("results_for_reader.csv").getFile().toPath();
        List<Result> expect = List.of(
                new Result(new Person("Ахмадеев Ринас", Gender.MALE),
                        Distance.TEN_KM, Duration.parse("PT29M1S")),
                new Result(new Person("Коробкина Елена", Gender.FEMALE),
                        Distance.TEN_KM, Duration.parse("PT31M49S")),
                new Result(new Person("Плохотников Константин", Gender.MALE),
                        Distance.TEN_KM, Duration.parse("PT29M18S"))

        );
        List<Result> actual = resultsReader.readFromFile(filePath);
        assertEquals(expect, actual);
    }
}