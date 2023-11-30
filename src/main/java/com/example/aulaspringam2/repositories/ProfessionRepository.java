package com.example.aulaspringam2.repositories;

import com.example.aulaspringam2.models.Person;
import com.example.aulaspringam2.models.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
