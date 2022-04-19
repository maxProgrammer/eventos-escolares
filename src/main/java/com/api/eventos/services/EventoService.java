package com.api.eventos.services;

import com.api.eventos.models.EventoModel;
import com.api.eventos.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventoService {

    /** Modo 1 de criar injeção
     @Autowired EventoRepository eventoRepository;
     */

    /**
     * Modo 2 de criar injeção
     */
    EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Transactional
    public EventoModel save(EventoModel eventoModel) {
        return eventoRepository.save(eventoModel);
    }

    public Page<EventoModel> findAll(Pageable pageable) {
        return eventoRepository.findAll(pageable);
    }

    public Optional<EventoModel> findById(UUID id) {
        return eventoRepository.findById(id);
    }

    @Transactional
    public void delete(EventoModel eventoModel) {
        eventoRepository.delete(eventoModel);
    }

}
