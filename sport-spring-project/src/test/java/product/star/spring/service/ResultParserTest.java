package product.star.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import product.star.spring.config.ResultsProcessorConfig;
import product.star.spring.model.Distance;
import product.star.spring.model.Gender;
import product.star.spring.model.Person;
import product.star.spring.model.Result;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ResultsProcessorConfig.class)
class ResultParserTest {

    private final ResultParser resultParser;

    @Autowired
    ResultParserTest(ResultParser resultParser) {
        this.resultParser = resultParser;
    }

    @Test
    void parseResultEquals() {
        String timeString = "PT29M1S";
        String resultString = "Ахмадеев Ринас,M,10 km,29:01";
        Person person = new Person("Ахмадеев Ринас", Gender.MALE);
        Result expect = new Result(person, Distance.TEN_KM, Duration.parse(timeString));
        assertEquals(expect, resultParser.parseResult(resultString));
    }

    @Test
    void parseResultNoEquals() {
        String timeString = "PT29M2S";
        String resultString = "Ахмадеев Ринас,M,10 km,29:01";
        Person person = new Person("Ахмадеев Ринас", Gender.MALE);
        Result expect = new Result(person, Distance.TEN_KM, Duration.parse(timeString));
        assertNotEquals(expect, resultParser.parseResult(resultString));
    }
}