package com.example.aulaspringam2.dtos;

import com.example.aulaspringam2.models.Person;
import com.example.aulaspringam2.models.Profession;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProfessionDTO {
    private Long id;

    private String name;

    private List<String> persons = new ArrayList<>();

    public ProfessionDTO() {}

    public ProfessionDTO(Profession profession) {
        this.id = profession.getId();
        this.name = profession.getName();

        this.persons = profession.getPersons().stream().map(Person::getFirstName).toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPersons() {
        return persons;
    }

    public void setPersons(List<String> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionDTO that = (ProfessionDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name,
                                                             that.name
        ) && Objects.equals(persons, that.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, persons);
    }
}
