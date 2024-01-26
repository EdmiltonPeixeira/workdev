package com.dev.edmilton.workdev.model;

import com.dev.edmilton.workdev.dto.AtaDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "atas")
@Entity(name = "Ata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ata {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST)
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
