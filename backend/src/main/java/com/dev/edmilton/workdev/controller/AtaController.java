package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.model.Ata;
import com.dev.edmilton.workdev.dto.AtaDto;
import com.dev.edmilton.workdev.model.Colaborador;
import com.dev.edmilton.workdev.service.AtaService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Realiza o cadastro de uma ata de reunião")
    public void cadastrar(@RequestBody @Valid AtaDto ataDto){
        ataService.create(ataDto);
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retorna todas as atas de reunião cadastradas")
    public List<Ata> listar(){
        return ataService.listarAtas();
    }

    @PutMapping("/{ataId}/colaboradores/{colaboradorId}")
    @Transactional
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Adiciona um colaborador em uma ata de reunião")
    public void adicionarColaborador(@PathVariable("ataId") Integer ataId, @PathVariable("colaboradorId") Integer colaboradorId,
                                     @RequestBody @Valid AtaDto ataDto){
        ataService.adicionarColaboradorEmAta(ataId, colaboradorId, ataDto);
    }

    @DeleteMapping("/{ataId}/colaboradores/{colaboradorId}")
    @Transactional
    @Operation(summary = "Remove um colaborador de uma ata de reunião")
    public void removerColaborador(@PathVariable("ataId") Integer ataId, @PathVariable("colaboradorId") Integer colaboradorId){
        ataService.removerColaboradorDeAta(ataId, colaboradorId);
    }

    @GetMapping("/workshopNome")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Filtra os colaboradores pelo nome do workshop")
    public List<ColaboradorDto> listarColaboradoresPorNomeWorkshop(@RequestParam(name = "nome") String nome){
        return ataService.colaboradoresPorWorkshopNome(nome);
    }

    @GetMapping("/dataRealizacao")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Filtra os colaboradores pela data do workshop")
    public List<ColaboradorDto> listarColaboradoresPorDataWorkshop(@RequestParam(name = "data") String data){
        return ataService.colaboradoresPorDataWorkshop(data);
    }
}
