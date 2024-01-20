package com.dev.edmilton.workdev.ata;

import com.dev.edmilton.workdev.colaborador.Colaborador;
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
    private int id;

    @OneToOne
    private Workshop workshop;

    @OneToMany
    private List<Colaborador> listaColaboradores;
}
