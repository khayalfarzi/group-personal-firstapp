package az.coders.grouppersonal.controller;

import az.coders.grouppersonal.model.Response;
import az.coders.grouppersonal.service.AzTownService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AzTownController {

    private final AzTownService service;

    public AzTownController(AzTownService service) {
        this.service = service;
    }

    @GetMapping("/towns/{id}")
    public Response getTown(@PathVariable Long id) {
        return service.getTownById(id);
    }
}