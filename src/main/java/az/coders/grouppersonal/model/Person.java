package az.coders.grouppersonal.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private long id;
    private String name;
    private String surname;
    private int age;
}