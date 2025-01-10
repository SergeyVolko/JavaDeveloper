package manager.exam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:exam.properties")
public class PropertiesConfiguration {
}
