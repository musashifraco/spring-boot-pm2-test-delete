package com.example.aulaspringam2.repositories;

import com.example.aulaspringam2.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
