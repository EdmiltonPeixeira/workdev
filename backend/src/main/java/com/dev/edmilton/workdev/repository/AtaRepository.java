package com.dev.edmilton.workdev.repository;

import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.model.Ata;
import com.dev.edmilton.workdev.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AtaRepository extends JpaRepository<Ata, Integer> {

    Ata findAtaById(Integer ataId);

    Ata findByWorkshop_Nome(@Param("nome") String nome);

    Ata findByWorkshop_DataRealizacao(@Param("dataRealizacao") Timestamp dataRealizacao);

    List<Ata> findByListaColaboradoresContaining(Colaborador colaborador);
}
