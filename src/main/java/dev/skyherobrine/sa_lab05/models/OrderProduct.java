package dev.skyherobrine.sa_lab05.models;

import java.time.LocalDate;
import lombok.*;
import jakarta.persistence.*;

@Entity @Table(name = "order_product")
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
@ToString
public class OrderProduct {
    @Id
    @Column(name = "order_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_date", nullable = false)
    @NonNull
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    @NonNull
    private Person person;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @NonNull
    private Product product;

    @Column(name = "order_quantity", nullable = false)
    @NonNull
    private Integer quantity;

}
