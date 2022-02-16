package az.coders.grouppersonal.dao.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class PersonEntity {

    @Id
    @Column(name = "id", length = 10_000_000)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_name",
            length = 32,
            nullable = false,
            columnDefinition = "varchar(32) default 'EMPTY'")
    private String name;

    @Column(name = "person_surname")
    private String surname;

    @Column(name = "person_age")
    private byte age;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}