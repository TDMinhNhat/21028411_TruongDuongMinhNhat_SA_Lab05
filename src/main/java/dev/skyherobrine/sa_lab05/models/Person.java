package dev.skyherobrine.sa_lab05.models;
import lombok.*;
import jakarta.persistence.*;

@Entity @Table(name = "person")
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
@ToString
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "person_name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "person_gender", nullable = false)
    @NonNull
    private Boolean gender;

    @Column(name = "person_address", nullable = false)
    @NonNull
    private String address;

    @Column(name = "person_phone", nullable = false)
    @NonNull
    private String phone;
}
