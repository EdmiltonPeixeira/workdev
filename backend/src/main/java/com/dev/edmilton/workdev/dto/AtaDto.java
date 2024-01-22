package com.dev.edmilton.workdev.dto;

import com.dev.edmilton.workdev.colaborador.Colaborador;
import com.dev.edmilton.workdev.workshop.Workshop;

import java.util.List;

public record AtaDto(
        Workshop workshop,
        List<Colaborador> listaColaboradores
) {
}
