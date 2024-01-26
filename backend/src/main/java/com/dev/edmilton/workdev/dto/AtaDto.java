package com.dev.edmilton.workdev.dto;

import com.dev.edmilton.workdev.model.Colaborador;
import com.dev.edmilton.workdev.model.Workshop;

import java.util.List;

public record AtaDto(
        Workshop workshop,
        List<Colaborador> listaColaboradores
) {
}
