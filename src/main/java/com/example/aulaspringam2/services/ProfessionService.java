package com.example.aulaspringam2.services;

import com.example.aulaspringam2.dtos.ProfessionDTO;
import com.example.aulaspringam2.models.Profession;
import com.example.aulaspringam2.repositories.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionService {
    @Autowired
    ProfessionRepository professionRepository;

    public List<ProfessionDTO> findAll() {
        List<Profession> professions = professionRepository.findAll();
        return professions.stream().map(x -> new ProfessionDTO(x)).toList();
    }

    public ProfessionDTO findById(Long id) {
        Profession profession = professionRepository.findById(id).orElseThrow();
        return new ProfessionDTO(profession);
    }

    public ProfessionDTO create(ProfessionDTO profession) {
        return null;
    }

    public ProfessionDTO update(ProfessionDTO profession) {
        Profession entity = professionRepository.findById(profession.getId()).orElseThrow();

        entity.setId(profession.getId());
        entity.setName(profession.getName());

        return null;
    }

    public void delete(Long id) {
        Profession entity = professionRepository.findById(id).orElseThrow();

        professionRepository.delete(entity);
    }
}
