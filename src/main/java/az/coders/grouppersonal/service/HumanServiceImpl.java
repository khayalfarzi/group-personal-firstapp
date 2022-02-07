package az.coders.grouppersonal.service;

import az.coders.grouppersonal.model.Human;
import az.coders.grouppersonal.repository.HumanRepository;
import az.coders.grouppersonal.repository.HumanRepositoryImpl;
import az.coders.grouppersonal.util.Loader;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class HumanServiceImpl implements HumanService {

    private final Gson gson = new Gson();
    private final HumanRepository repository = new HumanRepositoryImpl();

    @Override
    public void add(Human human) {
        getAll().forEach(h -> {
            if (h.equals(human))
                throw new RuntimeException("Human already exist");
        });

        repository.add(human);
    }

    @Override
    public List<Human> getAll() {

        List<Human> humans = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(Loader.path));

            while (sc.hasNext()) {
                String jsonStr = sc.nextLine();
                Human human = gson.fromJson(jsonStr, Human.class);
                humans.add(human);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return humans;
    }
}
