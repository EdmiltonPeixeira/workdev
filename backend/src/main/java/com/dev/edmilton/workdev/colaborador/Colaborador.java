package com.dev.edmilton.workdev.colaborador;

import com.dev.edmilton.workdev.dto.ColaboradorDto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "colaboradores")
@Entity(name = "Colaborador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Colaborador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    public Colaborador(ColaboradorDto colaboradorDto){
        this.nome = colaboradorDto.nome();
    }
}
