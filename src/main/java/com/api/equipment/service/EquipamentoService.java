package com.api.equipment.service;

import com.api.equipment.dto.EquipamentoDTO;
import com.api.equipment.model.Equipamento;
import com.api.equipment.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipamentoService {
    private final EquipamentoRepository repository;

    public Equipamento save(Equipamento equipamento) {
        return repository.save(equipamento);
    }

    public Equipamento findById(Long id) {
        if (!repository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Equipamento não encontrado");
        } else {
            return repository.findById(id).get();
        }

    }

    public List<Equipamento> findAll() {
        return repository.findAll().isEmpty() ? Collections.emptyList() : repository.findAll();
    }

    public Equipamento delete(Long id) {
        if (repository.findById(id).isPresent()) {
            Equipamento equipamento = repository.findById(id).get();
            repository.deleteById(equipamento.getId());
            return equipamento;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Equipamento não encontrado");
        }
    }

}
