package com.api.equipment.controller;

import com.api.equipment.dto.EquipamentoDTO;
import com.api.equipment.dto.EquipamentoDeleteDTO;
import com.api.equipment.model.Equipamento;
import com.api.equipment.service.EquipamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/equipamento")
@Tag(name = "Equipamento", description = "Endpoint para gerenciamento de Equipamentos")
public class EquipamentoController {

    private final EquipamentoService service;

    @Operation(description = "Cria um novo equipamento", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
    @PostMapping
    public Equipamento save(@RequestBody EquipamentoDTO equipamento) {
        return service.save(new Equipamento(null, equipamento.getNome(), equipamento.getCodigo(), equipamento.getDescricao()));
    }

    @Operation(description = "busca equipamento pelo id", parameters = {
            @Parameter(name = "id", in = ParameterIn.QUERY, required = true, description = "id parameter")
    })
    @GetMapping("/{id}")
    public EquipamentoDTO findById(@PathVariable Long id) {
        Equipamento equipamento = service.findById(id);
        return new EquipamentoDTO(equipamento.getNome(), equipamento.getCodigo(), equipamento.getDescricao());
    }

    @Operation(description = "Retorna uma lista de equipamentos")
    @GetMapping
    public List<Equipamento> findAll() {
        return service.findAll();
    }

    @Operation(description = "deleta equipamento pelo id", parameters = {
            @Parameter(name = "id", in = ParameterIn.QUERY, required = true, description = "id parameter")
    })
    @DeleteMapping("/{id}")
    public EquipamentoDeleteDTO delete(@PathVariable Long id) {
        Equipamento equipamento = service.delete(id);
        return new EquipamentoDeleteDTO(equipamento.getCodigo());
    }

}
