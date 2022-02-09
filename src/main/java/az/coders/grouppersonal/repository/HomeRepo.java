package az.coders.grouppersonal.repository;

import az.coders.grouppersonal.model.PersonEntity;
import org.springframework.stereotype.Repository;

@Repository
public class HomeRepo {

    public void addPerson(PersonEntity person) {
        System.out.println(person);
    }
}
