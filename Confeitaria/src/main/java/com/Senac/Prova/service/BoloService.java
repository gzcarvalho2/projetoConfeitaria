package com.Senac.Prova.service;

import com.Senac.Prova.dto.CreateBoloDto;
import com.Senac.Prova.entity.Bolo;
import com.Senac.Prova.repository.BoloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoloService {
    private final BoloRepository boloRepository;

    public BoloService(BoloRepository boloRepository) {
        this.boloRepository = boloRepository;
    }

    public List<Bolo> listarTodos() {
        return boloRepository.findAll();
    }

    public void criarBolo(CreateBoloDto createBoloDto) {
        Bolo bolo = new Bolo();
        bolo.setNome(createBoloDto.getNome());
        bolo.setDescricao(createBoloDto.getDescricao());
        bolo.setStatus(1);
        boloRepository.save(bolo);
    }
}
