package dev.skyherobrine.sa_lab05.models;

import java.time.LocalDate;
import lombok.*;
import jakarta.persistence.*;

@Entity @Table(name = "product")
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
@ToString
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", nullable = false, length = 200)
    @NonNull
    private String name;

    @Column(name = "product_date", nullable = false)
    @NonNull
    private LocalDate dateProduct;

    @Column(name = "product_date_expired", nullable = false)
    @NonNull
    private LocalDate dateExpired;

    @Column(name = "product_price", nullable = false)
    @NonNull
    private Double price;

    @Column(name = "product_quantity", nullable = false)
    @NonNull
    private Integer quantity;
}
