package az.coders.grouppersonal.service;

import az.coders.grouppersonal.model.Human;

import java.util.List;

public interface HumanService {

    void add(Human human);

    List<Human> getAll();
}
