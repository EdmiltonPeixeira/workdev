package com.dev.edmilton.workdev.ata;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AtaRepository extends JpaRepository<Ata, Integer> {

    @Query(value =
            "SELECT a.* FROM Ata a " +
            "INNER JOIN atas_colaboradores ac on ac.id_ata = a.id " +
            "WHERE ac.id_colaborador = :idColaborador", nativeQuery = true)
    public List<Ata> findAtasByIdColaborador(int idColaborador);

}
