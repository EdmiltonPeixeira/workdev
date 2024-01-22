package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.ata.AtaRepository;
import com.dev.edmilton.workdev.colaborador.Colaborador;
import com.dev.edmilton.workdev.colaborador.ColaboradorRepository;
import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.service.ColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ColaboradorDto colaboradorDto){
        colaboradorService.create(colaboradorDto);
    }

    public Page<ColaboradorDto> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao){
        return colaboradorService.listarColaboradores(paginacao);
    }
}
