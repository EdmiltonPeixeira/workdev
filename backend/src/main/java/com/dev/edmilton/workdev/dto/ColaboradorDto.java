package com.dev.edmilton.workdev.dto;

import com.dev.edmilton.workdev.colaborador.Colaborador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ColaboradorDto(
        Integer id,
        @NotBlank String nome) {
        public ColaboradorDto(Colaborador colaborador){
                this(colaborador.getId(), colaborador.getNome());
        }
}
