package az.coders.grouppersonal.dao.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name = "person_products",
            schema = "public",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = FlightEntity.class)
    @JoinColumn(name = "flight_id",
            referencedColumnName = "id")
    private FlightEntity flight;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}