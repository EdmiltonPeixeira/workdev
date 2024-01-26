package com.dev.edmilton.workdev.dto;

import com.dev.edmilton.workdev.model.Workshop;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record WorkshopDto(

        @NotBlank
        String nome,
        @NotNull
        @Column(name = "data_realizacao")
        LocalDateTime dataRealizacao,
        @NotBlank
        String descricao

) {
        public WorkshopDto(Workshop workshop){
                this(workshop.getNome(), workshop.getDataRealizacao(), workshop.getDescricao());
        }
}
