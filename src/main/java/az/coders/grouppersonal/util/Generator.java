package az.coders.grouppersonal.util;

import az.coders.grouppersonal.model.Human;

import java.util.List;

import static java.util.Arrays.asList;

public class Generator {

    public static List<Human> generateHumans() {
        return asList(
                Human.builder().id(1).name("Khayal").surname("Farziyev").age((byte) 23).build(),
                Human.builder().id(2).name("Dilgam").surname("Babirov").age((byte) 25).build(),
                Human.builder().id(3).name("Ismayil").surname("Nabiyev").age((byte) 20).build());
    }
}
