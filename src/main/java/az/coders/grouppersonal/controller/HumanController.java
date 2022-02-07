package az.coders.grouppersonal.controller;

import az.coders.grouppersonal.model.Human;
import az.coders.grouppersonal.service.HumanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/human")
public class HumanController {

    private final HumanService service;

    public HumanController(HumanService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public void add(@RequestBody Human human) {
        service.add(human);
    }

    @GetMapping("/all")
    public List<Human> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Human getById(@PathVariable long id) {
        return null;
    }

    @PatchMapping
    public void update(@RequestBody Human human) {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
    }

    @DeleteMapping("/all")
    public void deleteAll() {
    }
}