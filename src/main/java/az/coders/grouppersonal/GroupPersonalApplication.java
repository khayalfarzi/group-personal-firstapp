package az.coders.grouppersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GroupPersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupPersonalApplication.class, args);
    }
}