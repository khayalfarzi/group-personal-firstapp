package az.coders.grouppersonal.service;

import az.coders.grouppersonal.model.PersonEntity;
import az.coders.grouppersonal.model.dto.PersonDto;
import az.coders.grouppersonal.repository.HomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private final HomeRepo repo;

    public HomeService(HomeRepo repo) {
        this.repo = repo;
    }

    public void addPerson(PersonDto person) {

        PersonEntity entity = new PersonEntity();

        if (person != null) {
            entity.setId(person.getId());
            if (person.getName().length() < 3)
                return;
            else
                entity.setName(person.getName());
        } else return;

        repo.addPerson(entity);
    }
}
