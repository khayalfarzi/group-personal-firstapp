package az.coders.grouppersonal.util;

import az.coders.grouppersonal.model.Human;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Loader {

    public static final String path = "D:\\ideaproject\\group-personal\\src\\main\\resources\\templates\\humans.txt";

    public static void loadToFile(List<Human> humans) {
        File file = new File(path);

        try {
            if (file.createNewFile())
                System.out.println("Created successfully !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(file)) {

            humans.forEach(human -> {
                try {

                    Gson gson = new Gson();
                    String jsonStr = gson.toJson(human);
                    writer.write(jsonStr + System.lineSeparator());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
