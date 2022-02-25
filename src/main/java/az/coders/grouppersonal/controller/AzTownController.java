package az.coders.grouppersonal.controller;

import az.coders.grouppersonal.client.AzTownsClient;
import az.coders.grouppersonal.model.AzTown;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AzTownController {

    private final AzTownsClient client;

    public AzTownController(AzTownsClient client) {
        this.client = client;
    }

    @GetMapping("/towns")
    public AzTown getTown() {
        return client.getTowns();
    }
}
