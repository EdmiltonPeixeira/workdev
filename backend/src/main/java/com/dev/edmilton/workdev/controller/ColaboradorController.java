package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.ata.AtaRepository;
import com.dev.edmilton.workdev.colaborador.Colaborador;
import com.dev.edmilton.workdev.colaborador.ColaboradorRepository;
import com.dev.edmilton.workdev.dto.ColaboradorDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private AtaRepository ataRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ColaboradorDto colaboradorDto){
        colaboradorRepository.save(new Colaborador(colaboradorDto));
    }

}
