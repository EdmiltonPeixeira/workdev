package com.dev.edmilton.workdev.colaborador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
    Page<Colaborador> findAll(Pageable paginacao);
}
