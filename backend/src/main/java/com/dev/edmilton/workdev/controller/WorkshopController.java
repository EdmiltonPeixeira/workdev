package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.dto.WorkshopDto;
import com.dev.edmilton.workdev.workshop.Workshop;
import com.dev.edmilton.workdev.workshop.WorkshopRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping
    public Page<WorkshopDto> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(WorkshopDto::new);
    }
}
