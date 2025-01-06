package product.star.spring.service;

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

import static org.junit.jupiter.api.Assertions.*;

/**
 * Ахмадеев Ринас,M,10 km,29:01
 * Коробкина Елена,F,10 km,31:49
 * Плохотников Константин,M,10 km,29:18
 * Клопцов Юрий,M,10 km,30:01
 * Лебедева Людмила,F,10 km,34:30
 * Худеев Илларион,M,10 km,30:43
 * Сидорова Алла,F,10 km,33:24
 * Аввакуменкова Ульяна,F,10 km,35:08
 * Пономарев Владимир,M,10 km,29:54
 * Александрова Анастасия,F,10 km,32:39
 * Никитин Владимир,M,10 km,28:22
 * Тишакин Антон,M,10 km,30:37
 * Симакова Светлана,F,10 km,33:28
 * Аплачкина Светлана,F,10 km,33:46
 * Бородинова Александра,F,10 km,35:18
 * Неделин Дмитрий,M,10 km,29:52
 * Конякина Юлия,F,10 km,35:14
 * Петрова Анна,F,10 km,33:57
 * Сойкка Дмитрий,M,10 km,30:29
 * Адышкин Павел,M,10 km,29:54
 * [Result[person=Person[name=Никитин Владимир, gender=MALE], distance=TEN_KM, time=PT28M22S],
 * Result[person=Person[name=Ахмадеев Ринас, gender=MALE], distance=TEN_KM, time=PT29M1S],
 * Result[person=Person[name=Плохотников Константин, gender=MALE], distance=TEN_KM, time=PT29M18S]]
 */
@SpringBootTest(classes = ResultsProcessorConfig.class)
class ResultsProcessorTest {

    private final ResultsReader resultsReader;

    @Autowired
    ResultsProcessorTest(ResultsReader resultsReader) {
        this.resultsReader = resultsReader;
    }

    @Test
    void getFastestFirstThree() throws IOException {
        var path = new ClassPathResource("results.csv").getFile().toPath();
        List<Result> results = resultsReader.readFromFile(path);


        List<Result> expectResults = List.of(
                new Result(new Person("Никитин Владимир", Gender.MALE),
                        Distance.TEN_KM, Duration.parse("PT28M22S")),
                new Result(new Person("Ахмадеев Ринас", Gender.MALE),
                        Distance.TEN_KM, Duration.parse("PT29M1S")),
                new Result(new Person("Плохотников Константин", Gender.MALE),
                        Distance.TEN_KM, Duration.parse("PT29M18S"))
        );

        ResultsProcessor resultsProcessor = new ResultsProcessor(results);
        List<Result> actualResult = resultsProcessor.getFastest(Gender.MALE, Distance.TEN_KM, 3);
        assertEquals(expectResults, actualResult);
    }
}