package dev.skyherobrine.sa_lab05.repositories;

import dev.skyherobrine.sa_lab05.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public Optional<Person> findPersonByPhone(String phone);
}
