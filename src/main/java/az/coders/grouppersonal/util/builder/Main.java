package az.coders.grouppersonal.util.builder;

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.setId(1);

        Person pb = Person.builder().id(1).name("X").build();
        System.out.println(pb);
    }
}
