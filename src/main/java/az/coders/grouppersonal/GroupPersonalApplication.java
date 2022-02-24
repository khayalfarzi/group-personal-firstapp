package az.coders.grouppersonal;

import az.coders.grouppersonal.client.AzTownsClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

@EnableFeignClients
@SpringBootApplication
public class GroupPersonalApplication {

    private final AzTownsClient client;

    public GroupPersonalApplication(AzTownsClient client) {
        this.client = client;
    }

    public static void main(String[] args) {
        SpringApplication.run(GroupPersonalApplication.class, args);
    }

    @PostConstruct
    public void loadData() {
        System.out.println(
                client.getTowns()
        );
    }
}
