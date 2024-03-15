package dev.skyherobrine.sa_lab05;

import dev.skyherobrine.sa_lab05.models.Product;
import dev.skyherobrine.sa_lab05.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class SaLab05Application {

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(SaLab05Application.class, args);
    }

//    @Bean
    public CommandLineRunner runner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                productService.save(new Product("Cheese",
                        LocalDate.now(),
                        LocalDate.now().plusMonths(ThreadLocalRandom.current().nextLong(12, 24)),
                        50d,
                        ThreadLocalRandom.current().nextInt(150, 300)));
                productService.save(new Product("Rice",
                        LocalDate.now(),
                        LocalDate.now().plusMonths(ThreadLocalRandom.current().nextLong(12, 24)),
                        25d,
                        ThreadLocalRandom.current().nextInt(150, 300)));
                productService.save(new Product("Milk",
                        LocalDate.now(),
                        LocalDate.now().plusMonths(ThreadLocalRandom.current().nextLong(12, 24)),
                        15d,
                        ThreadLocalRandom.current().nextInt(150, 300)));
                productService.save(new Product("Egg",
                        LocalDate.now(),
                        LocalDate.now().plusMonths(ThreadLocalRandom.current().nextLong(12, 24)),
                        15d,
                        ThreadLocalRandom.current().nextInt(150, 300)));
            }
        };
    }
}
