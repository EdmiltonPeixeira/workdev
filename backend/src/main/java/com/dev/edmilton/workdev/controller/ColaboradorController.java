package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.dto.ColaboradorEWorkshopsDto;
import com.dev.edmilton.workdev.service.ColaboradorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
@CrossOrigin(origins = "http://localhost:8081")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastra um colaborador na base de dados")
    public void cadastrar(@RequestBody @Valid ColaboradorDto colaboradorDto){
        colaboradorService.create(colaboradorDto);
    }

    @GetMapping("/todos")
    @Operation(summary = "Exibe a lista de todos os colaboradores cadastrados")
    public List<ColaboradorDto> listar(){
        return colaboradorService.listarColaboradores();
    }

    @GetMapping
    @Operation(summary = "Exibe todos os colaboradores e os workshops que participaram")
    public List<ColaboradorEWorkshopsDto> listaColaboradoresEWorkshop(){
        return colaboradorService.listarColaboradoresComWorkshops();
    }

}
