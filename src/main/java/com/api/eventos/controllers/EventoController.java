package com.api.eventos.controllers;

import com.api.eventos.dtos.EventoDto;
import com.api.eventos.models.EventoModel;
import com.api.eventos.services.EventoService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/evento")
public class EventoController {
    final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveEvento(@RequestBody @Valid EventoDto eventoDto) {
        var eventoModel = new EventoModel();
        //convert DTO em Model
        BeanUtils.copyProperties(eventoDto, eventoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.save(eventoModel));
    }

    @GetMapping
    public ResponseEntity<Page<EventoModel>> getAllEventos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(eventoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEvento(@PathVariable(value= "id") UUID id){
        Optional<EventoModel> eventoModelOptional = eventoService.findById(id);
        if(!eventoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(eventoModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEvento(@PathVariable(value = "id") UUID id, @RequestBody @Valid EventoDto eventoDto){
        Optional<EventoModel> eventoModelOptional = eventoService.findById(id);
        if(!eventoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento not found");
        }

        var parkingSpotModel = new EventoModel();
        BeanUtils.copyProperties(eventoDto,parkingSpotModel);
        parkingSpotModel.setId(eventoModelOptional.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(eventoService.save(parkingSpotModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEvento(@PathVariable(value = "id") UUID id){
        Optional<EventoModel> eventoModelOptional = eventoService.findById(id);
        if(!eventoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
        }
        eventoService.delete(eventoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parsing Event deleted successfully");
    }

}
