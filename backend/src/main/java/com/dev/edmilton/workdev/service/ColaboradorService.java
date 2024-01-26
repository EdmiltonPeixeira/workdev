package com.dev.edmilton.workdev.service;

import com.dev.edmilton.workdev.model.Ata;
import com.dev.edmilton.workdev.model.Colaborador;
import com.dev.edmilton.workdev.model.Workshop;
import com.dev.edmilton.workdev.repository.AtaRepository;
import com.dev.edmilton.workdev.repository.ColaboradorRepository;
import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.dto.ColaboradorEWorkshopsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private AtaRepository ataRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void create(ColaboradorDto colaboradorDto){
        colaboradorRepository.save(new Colaborador(colaboradorDto));
    }

    public List<ColaboradorDto> listarColaboradores(){
        return colaboradorRepository.findAll().stream().map(ColaboradorDto::new).toList();
    }

    public List<ColaboradorEWorkshopsDto> listarColaboradoresComWorkshops(){
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
        List<ColaboradorEWorkshopsDto> lista = new ArrayList<>();
        for(int i = 0; i < colaboradores.size(); i++){
            List<Ata> atas = ataRepository.findByListaColaboradoresContaining(colaboradores.get(i));
            ColaboradorEWorkshopsDto colaboradorEWorkshopsDto = new ColaboradorEWorkshopsDto();
            colaboradorEWorkshopsDto.setColaborador(colaboradores.get(i));
            for(int j = 0; j < atas.size(); j++){
                List<Workshop> listaWorkshops = new ArrayList<>();
                listaWorkshops.add(atas.get(j).getWorkshop());
                if(j == atas.size() - 1) colaboradorEWorkshopsDto.setListaWorkshops(listaWorkshops);
            }
            lista.add(colaboradorEWorkshopsDto);
        }
        return lista;
    }

}
