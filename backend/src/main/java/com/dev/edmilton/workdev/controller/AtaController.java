package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.ata.Ata;
import com.dev.edmilton.workdev.ata.AtaRepository;
import com.dev.edmilton.workdev.dto.AtaDto;
import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.dto.WorkshopDto;
import com.dev.edmilton.workdev.service.AtaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
