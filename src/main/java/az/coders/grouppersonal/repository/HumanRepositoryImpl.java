package az.coders.grouppersonal.repository;

import az.coders.grouppersonal.model.Human;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanRepositoryImpl implements HumanRepository {

    public static final String path = "D:\\ideaproject\\group-personal\\src\\main\\resources\\templates\\humans.txt";

    @Override
    public void add(Human human) {
        Gson gson = new Gson();
        List<Human> humans = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNext()) {
                Human h = gson.fromJson(sc.nextLine(), Human.class);
                humans.add(h);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(path)) {

            String jsonStr = gson.toJson(human);

            humans.forEach(h -> {
                try {
                    writer.write(gson.toJson(h) + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.write(jsonStr);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
