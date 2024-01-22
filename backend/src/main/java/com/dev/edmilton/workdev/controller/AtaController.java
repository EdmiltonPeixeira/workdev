package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.ata.Ata;
import com.dev.edmilton.workdev.ata.AtaRepository;
import com.dev.edmilton.workdev.dto.AtaDto;
import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.dto.WorkshopDto;
import com.dev.edmilton.workdev.service.AtaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atas")
public class AtaController {

    @Autowired
    private AtaService ataService;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid AtaDto ataDto){
        ataService.create(ataDto);
    }

    @GetMapping
    public List<Ata> listar(){
        return ataService.listarAtas();
    }
}
