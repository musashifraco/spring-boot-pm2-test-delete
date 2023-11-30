package com.example.aulaspringam2.controllers;

import com.example.aulaspringam2.dtos.ProfessionDTO;
import com.example.aulaspringam2.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profession")
public class ProfessionController {

    @Autowired
    ProfessionService professionService;

    @GetMapping
    public List<ProfessionDTO> findAllController() {
        return professionService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ProfessionDTO findById(@PathVariable(value = "id") Long id) {
        return professionService.findById(id);
    }

    @PostMapping
    public ProfessionDTO create(@RequestBody ProfessionDTO profession) {
        return professionService.create(profession);
    }

    @PutMapping
    public ProfessionDTO update(@RequestBody ProfessionDTO profession) {
        return professionService.update(profession);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        professionService.delete(id);
    }
}
