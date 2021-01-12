package com.api.equipment.controller;

import com.api.equipment.dto.EquipamentoDTO;
import com.api.equipment.dto.EquipamentoDeleteDTO;
import com.api.equipment.exception.ApiError;
import com.api.equipment.model.Equipamento;
import com.api.equipment.service.EquipamentoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/equipamento")
public class EquipamentoController {

    private final EquipamentoService service;

    @ApiOperation(
            value = "Salva Equipamento"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Requisição mal formatada", response = ApiError.class),
            @ApiResponse(code = 500, message = "Erro na api", response = ApiError.class)
    })
    @PostMapping
    public Equipamento save(@RequestBody EquipamentoDTO equipamento) {
        return service.save(new Equipamento(null, equipamento.getNome(), equipamento.getCodigo(), equipamento.getDescricao()));
    }


    @ApiOperation(
            value = "Recupera dados do equipamento por ID"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Requisição mal formatada", response = ApiError.class),
            @ApiResponse(code = 500, message = "Erro na api", response = ApiError.class)
    })
    @GetMapping("/{id}")
    public EquipamentoDTO findById(@PathVariable Long id) {
        Equipamento equipamento = service.findById(id);
        return new EquipamentoDTO(equipamento.getNome(), equipamento.getCodigo(), equipamento.getDescricao());
    }

    @ApiOperation(
            value = "Recupera todos os equipamentos cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Requisição mal formatada", response = ApiError.class),
            @ApiResponse(code = 500, message = "Erro na api", response = ApiError.class)
    })
    @GetMapping
    public List<Equipamento> findAll() {
        return service.findAll();
    }


    @ApiOperation(
            value = "Deleta equipamento"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Requisição mal formatada", response = ApiError.class),
            @ApiResponse(code = 500, message = "Erro na api", response = ApiError.class)
    })
    @DeleteMapping("/{id}")
    public EquipamentoDeleteDTO delete(@PathVariable Long id) {
        Equipamento equipamento = service.delete(id);
        return new EquipamentoDeleteDTO(equipamento.getCodigo());
    }

}
