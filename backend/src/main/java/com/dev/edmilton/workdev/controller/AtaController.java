package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.model.Ata;
import com.dev.edmilton.workdev.dto.AtaDto;
import com.dev.edmilton.workdev.model.Colaborador;
import com.dev.edmilton.workdev.service.AtaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/atas")
@CrossOrigin(origins = "http://localhost:8081")
public class AtaController {

    @Autowired
    private AtaService ataService;


    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody @Valid AtaDto ataDto){
        ataService.create(ataDto);
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Ata> listar(){
        return ataService.listarAtas();
    }

    @PutMapping("/{ataId}/colaboradores/{colaboradorId}")
    @Transactional
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void adicionarColaborador(@PathVariable("ataId") Integer ataId, @PathVariable("colaboradorId") Integer colaboradorId,
                                     @RequestBody @Valid AtaDto ataDto){
        ataService.adicionarColaboradorEmAta(ataId, colaboradorId, ataDto);
    }

    @DeleteMapping("/{ataId}/colaboradores/{colaboradorId}")
    @Transactional
    public void removerColaborador(@PathVariable("ataId") Integer ataId, @PathVariable("colaboradorId") Integer colaboradorId){
        ataService.removerColaboradorDeAta(ataId, colaboradorId);
    }

    @GetMapping("/workshopNome")
    @ResponseStatus(HttpStatus.OK)
    public List<ColaboradorDto> listarColaboradoresPorNomeWorkshop(@RequestParam(name = "nome") String nome){
        return ataService.colaboradoresPorWorkshopNome(nome);
    }

    @GetMapping("/dataRealizacao")
    @ResponseStatus(HttpStatus.OK)
    public List<ColaboradorDto> listarColaboradoresPorDataWorkshop(@RequestParam(name = "data") String data){
        return ataService.colaboradoresPorDataWorkshop(data);
    }
}
