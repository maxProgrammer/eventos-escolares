package com.api.eventos.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
public class EventoDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String local;
    @NotBlank
    @Size(max = 10)
    private String data;
    @NotBlank
    @Size(max = 8)
    private String horario;

}
