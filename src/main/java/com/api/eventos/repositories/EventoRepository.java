package com.api.eventos.repositories;

import com.api.eventos.models.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EventoRepository extends JpaRepository<EventoModel, UUID> {

}
