package com.dev.edmilton.workdev.service;

import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.model.Ata;
import com.dev.edmilton.workdev.repository.AtaRepository;
import com.dev.edmilton.workdev.model.Colaborador;
import com.dev.edmilton.workdev.repository.ColaboradorRepository;
import com.dev.edmilton.workdev.dto.AtaDto;
import com.dev.edmilton.workdev.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void adicionarColaboradorEmAta(Integer ataId, Integer colaboradorId, AtaDto ataDto){
        if((colaboradorId != null && colaboradorRepository.existsById(colaboradorId))
            && ataId != null && ataRepository.existsById(ataId)){
            Colaborador colaborador = colaboradorRepository.findColaboradorById(colaboradorId);
            Ata ata = ataRepository.findAtaById(ataId);
            ata.getListaColaboradores().add(colaborador);
            ataRepository.save(ata);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void removerColaboradorDeAta(Integer ataId, Integer colaboradorId){
        if((colaboradorId != null && colaboradorRepository.existsById(colaboradorId))
                && ataId != null && ataRepository.existsById(ataId)){
            Colaborador colaborador = colaboradorRepository.findColaboradorById(colaboradorId);
            Ata ata = ataRepository.findAtaById(ataId);
            ata.getListaColaboradores().remove(colaborador);
            ataRepository.save(ata);
        }
    }

    public List<ColaboradorDto> colaboradoresPorWorkshopNome(String workshopNome){
        Ata atas = ataRepository.findByWorkshop_Nome(workshopNome);
        return atas.getListaColaboradores().stream().map(ColaboradorDto::new).toList();
    }

    public List<ColaboradorDto> colaboradoresPorDataWorkshop(String dataRealizacao){
        Timestamp dataRealizacaoTimestamp = Timestamp.valueOf(dataRealizacao);
        Ata atas = ataRepository.findByWorkshop_DataRealizacao(dataRealizacaoTimestamp);
        return atas.getListaColaboradores().stream().map(ColaboradorDto::new).toList();
    }
}
