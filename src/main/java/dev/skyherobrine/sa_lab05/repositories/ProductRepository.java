package dev.skyherobrine.sa_lab05.repositories;

import dev.skyherobrine.sa_lab05.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
