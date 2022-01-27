package az.coders.grouppersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class GroupPersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupPersonalApplication.class, args);
    }

    @PostConstruct
    public void loadData() {
        System.out.println("Post constructor is started.");
    }
}
