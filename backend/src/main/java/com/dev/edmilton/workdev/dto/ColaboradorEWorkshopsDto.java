package com.dev.edmilton.workdev.dto;

import com.dev.edmilton.workdev.model.Colaborador;
import com.dev.edmilton.workdev.model.Workshop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ColaboradorEWorkshopsDto {
    private Colaborador colaborador;
    private List<Workshop> listaWorkshops;

    public ColaboradorEWorkshopsDto(Colaborador colaborador, List<Workshop> listaWorkshops){
        this.colaborador = colaborador;
        this.listaWorkshops = listaWorkshops;
    }
}
