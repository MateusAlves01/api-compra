package com.compra.apicompra.service;

import com.compra.apicompra.exceptionhandler.EntregaException;
import com.compra.apicompra.model.Entrega;
import com.compra.apicompra.model.Ocorrencia;
import com.compra.apicompra.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OcorrenciaService {

    private BuscarService buscarService;

    @Transactional
    public Ocorrencia registrar(Long id, String descricao){
        Entrega entrega = buscarService.buscar(id);
        return entrega.adicionarOcorrencia(descricao);
    }

}
