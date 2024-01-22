package com.dev.edmilton.workdev.service;

import com.dev.edmilton.workdev.colaborador.Colaborador;
import com.dev.edmilton.workdev.colaborador.ColaboradorRepository;
import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.dto.WorkshopDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void create(ColaboradorDto colaboradorDto){
        colaboradorRepository.save(new Colaborador(colaboradorDto));
    }

    public Page<ColaboradorDto> listarColaboradores(Pageable paginacao){
        return colaboradorRepository.findAll(paginacao).map(ColaboradorDto::new);
    }

}
