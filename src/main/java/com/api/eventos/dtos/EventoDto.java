package com.api.eventos.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
