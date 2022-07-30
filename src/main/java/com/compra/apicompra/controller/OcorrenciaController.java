package com.compra.apicompra.controller;

import com.compra.apicompra.mapper.OcorrenciaMapper;
import com.compra.apicompra.model.Entrega;
import com.compra.apicompra.model.Ocorrencia;
import com.compra.apicompra.requestDTO.OcorrenciaRequest;
import com.compra.apicompra.response.OcorrenciaResponse;
import com.compra.apicompra.service.BuscarService;
import com.compra.apicompra.service.OcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{id}/ocorrencias")
public class OcorrenciaController {

    private OcorrenciaService ocorrenciaService;
    private BuscarService buscarService;
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public OcorrenciaResponse registrar(@PathVariable Long id, @Valid @RequestBody
                                        OcorrenciaRequest ocorrenciaRequest){
       Ocorrencia ocorrenciaRegistrada = ocorrenciaService.
               registrar(id, ocorrenciaRequest.getDescricao());

       return  ocorrenciaMapper.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaResponse> listar(@PathVariable Long id){
        Entrega entrega = buscarService.buscar(id);
        return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());
    }
}
