package az.coders.grouppersonal.repository;

import az.coders.grouppersonal.model.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository {

    void add(Human human);
}
