package product.star.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import product.star.spring.config.ResultsProcessorConfig;
import product.star.spring.model.Distance;
import product.star.spring.model.Gender;
import product.star.spring.model.Result;
import product.star.spring.service.ResultsProcessor;
import product.star.spring.service.ResultsReader;
import java.io.IOException;
import java.util.List;

public class ResultsProcessorMain {

	public static void main(String[] args) throws IOException {
		var applicationContext = new AnnotationConfigApplicationContext(ResultsProcessorConfig.class);

		var resultsReader = applicationContext.getBean(ResultsReader.class);
		var filePath = new ClassPathResource("results.csv").getFile().toPath();
		var results = resultsReader.readFromFile(filePath);

		var resultsProcessor = new ResultsProcessor(results);
		List<Result> fastestMen = resultsProcessor.getFastest(Gender.MALE, Distance.TEN_KM, 3);

		System.out.println(fastestMen);
	}
}
