package com.api.eventos.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="TB_EVENTO")
@Data
public class EventoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false,length = 130)
    private String nome;
    @Column(nullable = false,length = 130)
    private String local;
    @Column(nullable = false,length = 10)
    private String data;
    @Column(nullable = false,length = 8)
    private String horario;

}
