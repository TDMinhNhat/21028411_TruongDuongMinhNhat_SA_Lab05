package dev.skyherobrine.sa_lab05.services.impl;

import dev.skyherobrine.sa_lab05.models.Person;
import dev.skyherobrine.sa_lab05.repositories.PersonRepository;
import dev.skyherobrine.sa_lab05.services.IServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IServices<Person, Long> {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean save(Person entity) {
        try {
            personRepository.save(entity);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Person entity) {
        try {
            personRepository.save(entity);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Person person) {
        try {
            personRepository.delete(person);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Person> findById(Long aLong) {
        return personRepository.findById(aLong);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findPersonByPhone(String phone) {
        return personRepository.findPersonByPhone(phone);
    }
}
