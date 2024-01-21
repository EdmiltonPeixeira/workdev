package com.dev.edmilton.workdev.colaborador;

import com.dev.edmilton.workdev.dto.ColaboradorDto;
import com.dev.edmilton.workdev.workshop.Workshop;

import java.util.List;

public record DadosListagemColaborador(
        ColaboradorDto colaboradorDto,
        List<Workshop> listaWorkshop
) {
}
