package com.dev.edmilton.workdev.dto;

import com.dev.edmilton.workdev.workshop.Workshop;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

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
