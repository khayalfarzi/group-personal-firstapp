package az.coders.grouppersonal.config;

import az.coders.grouppersonal.repository.HumanRepository;
import az.coders.grouppersonal.repository.HumanRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HumanRepository humanRepository() {
        return new HumanRepositoryImpl();
    }
}