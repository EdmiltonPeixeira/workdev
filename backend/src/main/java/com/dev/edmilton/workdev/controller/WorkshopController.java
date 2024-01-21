package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.dto.WorkshopDto;
import com.dev.edmilton.workdev.workshop.Workshop;
import com.dev.edmilton.workdev.workshop.WorkshopRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/workshops")
public class WorkshopController {

    @Autowired
    WorkshopRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid WorkshopDto dados){
        repository.save(new Workshop(dados));
    }
}
