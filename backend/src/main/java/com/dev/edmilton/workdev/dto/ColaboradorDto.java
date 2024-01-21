package com.dev.edmilton.workdev.dto;

import com.dev.edmilton.workdev.colaborador.Colaborador;
import jakarta.validation.constraints.NotBlank;

public record ColaboradorDto(@NotBlank String nome) {
        public ColaboradorDto(Colaborador colaborador){
                this(colaborador.getNome());
        }
}
