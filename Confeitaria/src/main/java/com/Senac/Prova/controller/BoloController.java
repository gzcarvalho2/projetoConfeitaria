package com.Senac.Prova.controller;

import com.Senac.Prova.dto.CreateBoloDto;
import com.Senac.Prova.entity.Bolo;
import com.Senac.Prova.service.BoloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bolo")
public class BoloController {
    private final BoloService boloService;

    public BoloController(BoloService boloService) {
        this.boloService = boloService;
    }

    @GetMapping("/Listar")
    public ResponseEntity <List<Bolo>> listarTodos(){
        return ResponseEntity.ok(boloService.listarTodos());
    }
    @PatchMapping("/criar")
    public ResponseEntity<Void> criarBolo (@RequestBody CreateBoloDto createBoloDto){
        boloService.criarBolo(createBoloDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
