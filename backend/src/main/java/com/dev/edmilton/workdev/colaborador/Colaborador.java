package com.dev.edmilton.workdev.colaborador;

import com.dev.edmilton.workdev.dto.ColaboradorDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "colaboradores")
@Entity(name = "Colaborador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Colaborador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    public Colaborador(ColaboradorDto colaboradorDto){
        this.nome = colaboradorDto.nome();
    }
}
