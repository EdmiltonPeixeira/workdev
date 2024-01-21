package com.dev.edmilton.workdev.workshop;

import com.dev.edmilton.workdev.dto.WorkshopDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "workshops")
@Entity(name = "Workshop")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column(name = "data_realizacao")
    private LocalDateTime dataRealizacao;

    @Column
    private String descricao;

    public Workshop(WorkshopDto workshopDto){
        this.nome = workshopDto.nome();
        this.dataRealizacao = workshopDto.dataRealizacao();
        this.descricao = workshopDto.descricao();
    }
}
