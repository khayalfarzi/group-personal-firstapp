package az.coders.grouppersonal;

import az.coders.grouppersonal.dao.entity.Gender;
import az.coders.grouppersonal.dao.entity.PersonEntity;
import az.coders.grouppersonal.dao.repository.PersonRepository;
import az.coders.grouppersonal.model.Human;
import az.coders.grouppersonal.util.Generator;
import az.coders.grouppersonal.util.Loader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class GroupPersonalApplication {

    private final PersonRepository repository;

    public GroupPersonalApplication(PersonRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(GroupPersonalApplication.class, args);
    }

//    @PostConstruct
    public void loadData() {

//        List<Human> humans = Generator.generateHumans();
//        Loader.loadToFile(humans);

//        PersonEntity person = PersonEntity.builder()
////                .id(3L)
//                .name("Ali")
//                .surname("Aliyev")
//                .age((byte) 62)
//                .gender(Gender.MALE)
//                .build();
//
//        repository.save(person);

        PersonEntity person = repository.findById(4L).get();

        person.setAge((byte) 52);

        repository.save(person);
    }
}
