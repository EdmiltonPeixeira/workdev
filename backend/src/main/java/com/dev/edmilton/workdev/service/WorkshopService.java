package com.dev.edmilton.workdev.service;

import com.dev.edmilton.workdev.dto.WorkshopDto;
import com.dev.edmilton.workdev.model.Workshop;
import com.dev.edmilton.workdev.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkshopService {

    @Autowired
    private WorkshopRepository workshopRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void create(WorkshopDto workshopDto){
        workshopRepository.save(new Workshop(workshopDto));
    }

    public Page<WorkshopDto> listarWorkshops(Pageable paginacao){
        return workshopRepository.findAll(paginacao).map(WorkshopDto::new);
    }
}
