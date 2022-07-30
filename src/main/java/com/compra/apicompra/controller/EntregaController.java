package com.compra.apicompra.controller;

import com.compra.apicompra.mapper.EntregaMapper;
import com.compra.apicompra.model.Entrega;
import com.compra.apicompra.repository.EntregaRepository;
import com.compra.apicompra.requestDTO.EntregaRequest;
import com.compra.apicompra.response.EntregaResponse;
import com.compra.apicompra.service.EntregaService;
import com.compra.apicompra.service.FinalizacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaService entregaService;
    private EntregaRepository entregaRepository;
    private EntregaMapper entregaMapper;
    private FinalizacaoEntregaService finalizacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaResponse solicitar(@Valid @RequestBody EntregaRequest entregaRequest) {
        Entrega novaEntrega = entregaMapper.toEntity(entregaRequest);
        return entregaMapper.toModel(entregaService.solicitar(novaEntrega));
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  finalizar(@PathVariable Long entregaId){
        finalizacaoEntregaService.finalizar(entregaId);
    }

    @GetMapping
    public List<EntregaResponse> listar(){
        return entregaMapper.toCollectionService(entregaRepository.findAll()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaResponse> buscar(@PathVariable Long id) {
        return entregaRepository.findById(id)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

}
