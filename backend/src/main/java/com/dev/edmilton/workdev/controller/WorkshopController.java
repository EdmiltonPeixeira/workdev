package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.dto.WorkshopDto;
import com.dev.edmilton.workdev.service.WorkshopService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workshops")
@CrossOrigin(origins = "http://localhost:8081")
public class WorkshopController {

    @Autowired
    WorkshopService workshopService;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastra um workshop")
    public void cadastrar(@RequestBody @Valid WorkshopDto workshopDto){
        workshopService.create(workshopDto);
    }

    @GetMapping
    @Operation(summary = "Exibe a lista de todos os workshops")
    public Page<WorkshopDto> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao){
        return workshopService.listarWorkshops(paginacao);
    }
}
