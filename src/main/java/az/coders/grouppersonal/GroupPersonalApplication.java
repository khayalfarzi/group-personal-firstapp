package az.coders.grouppersonal;

import az.coders.grouppersonal.model.Human;
import az.coders.grouppersonal.util.Generator;
import az.coders.grouppersonal.util.Loader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class GroupPersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupPersonalApplication.class, args);
    }

    @PostConstruct
    public void loadData() {

        List<Human> humans = Generator.generateHumans();
        Loader.loadToFile(humans);

    }
}
