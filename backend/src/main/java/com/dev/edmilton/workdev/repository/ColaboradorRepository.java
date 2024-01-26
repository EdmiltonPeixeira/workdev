package com.dev.edmilton.workdev.repository;

import com.dev.edmilton.workdev.dto.ColaboradorEWorkshopsDto;
import com.dev.edmilton.workdev.model.Colaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
    List<Colaborador> findAll();

    Colaborador findColaboradorById(Integer idColaborador);

}
