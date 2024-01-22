package com.dev.edmilton.workdev.service;

import com.dev.edmilton.workdev.ata.Ata;
import com.dev.edmilton.workdev.ata.AtaRepository;
import com.dev.edmilton.workdev.colaborador.Colaborador;
import com.dev.edmilton.workdev.colaborador.ColaboradorRepository;
import com.dev.edmilton.workdev.dto.AtaDto;
import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.workshop.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AtaService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    WorkshopRepository workshopRepository;

    @Autowired
    AtaRepository ataRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void create(AtaDto ataDto){
        for(Colaborador colaborador : ataDto.listaColaboradores()){
            colaboradorRepository.save(colaborador);
        }
        workshopRepository.save(ataDto.workshop());
        ataRepository.save(new Ata(ataDto));
    }

    public List<Ata> listarAtas(){
        return ataRepository.findAll();
    }

    public void adicionarColaborador(ColaboradorDto colaboradorDto){
        Colaborador colaborador = new Colaborador(colaboradorDto);
        if (colaborador.getId() != null && colaboradorRepository.existsById(colaborador.getId())){

        }
    }
}
