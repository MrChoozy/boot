package com.mrchoozy.demoboot.services;

import com.mrchoozy.demoboot.entity.Person;
import com.mrchoozy.demoboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void save (Person person){
        personRepository.save(person);
    }
}
