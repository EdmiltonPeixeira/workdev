package com.dev.edmilton.workdev.repository;

import com.dev.edmilton.workdev.model.Workshop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, Integer> {
    Page<Workshop> findAll(Pageable paginacao);

    Workshop findWorkshopByNome(String nome);
}
