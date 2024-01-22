package com.dev.edmilton.workdev.ata;

import com.dev.edmilton.workdev.colaborador.Colaborador;
import com.dev.edmilton.workdev.dto.AtaDto;
import com.dev.edmilton.workdev.workshop.Workshop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "atas")
@Entity(name = "Ata")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ata {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "workshop_id", referencedColumnName = "id")
    private Workshop workshop;

    @ManyToMany
    @JoinTable(
            name = "atas_colaboradores",
            joinColumns = @JoinColumn(name = "ata_id"),
            inverseJoinColumns = @JoinColumn(name = "colaborador_id"))
    private List<Colaborador> listaColaboradores;

    public Ata(AtaDto ataDto){
        this.workshop = ataDto.workshop();
        this.listaColaboradores = ataDto.listaColaboradores();
    }
}
