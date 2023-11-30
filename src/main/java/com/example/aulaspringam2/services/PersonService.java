package com.example.aulaspringam2.services;

import com.example.aulaspringam2.dtos.PersonDTO;
import com.example.aulaspringam2.models.Person;
import com.example.aulaspringam2.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<PersonDTO> findAll() {
        List<Person> persons = personRepository.findAll();

        return persons.stream().map(x -> new PersonDTO(x)).toList();
    }

    public PersonDTO findById(Long id) {
        Person person = personRepository.findById(id).orElseThrow();
        return new PersonDTO(person);
    }

    public PersonDTO create(PersonDTO personDTO) {
        return null;
    }

    public PersonDTO update(PersonDTO personDTO) {
        Person entity = personRepository.findById(personDTO.getId()).orElseThrow();

        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setEmail(personDTO.getEmail());

        return null;
    }

    public void delete(Long id) {
        Person entity = personRepository.findById(id).orElseThrow();

        personRepository.delete(entity);
    }
}
