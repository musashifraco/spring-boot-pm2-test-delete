package com.example.aulaspringam2.dtos;

import com.example.aulaspringam2.models.Person;
import com.example.aulaspringam2.models.Profession;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private List<String> professions = new ArrayList<>();

    public PersonDTO() {}

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.professions = person.getProfessions().stream().map(Profession::getName).toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getProfessions() {
        return professions;
    }

    public void setProfessions(List<String> professions) {
        this.professions = professions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) && Objects.equals(firstName,
                                                                  personDTO.firstName
        ) && Objects.equals(lastName, personDTO.lastName) && Objects.equals(email,
                                                                            personDTO.email
        ) && Objects.equals(professions, personDTO.professions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, professions);
    }
}
