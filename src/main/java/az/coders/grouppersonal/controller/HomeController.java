package az.coders.grouppersonal.controller;


import az.coders.grouppersonal.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final List<Person> people = new ArrayList<>();

    @GetMapping("/health")
    public String health() {
        return "Success";
    }

    @GetMapping("/all")
    public List<Person> getPeople() {
        Person person = Person.builder()
                .id(1L)
                .name("Khayal")
                .surname("Farziyev")
                .age(23)
                .build();

        System.out.println(person);
        return people;
    }

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person) {
        people.add(person);
    }

    @PutMapping("/update")
    public void updatePerson(Person person) {
        long id = person.getId();

        people.forEach(person1 -> {
            if (person1.getId() == id) {
                person1.setName(person.getName());
                person1.setSurname(person.getSurname());
                person1.setAge(person.getAge());
            }
        });
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") long id) {
        people.forEach(person -> {
            if (person.getId() == id)
                people.remove(person);
        });
    }
}