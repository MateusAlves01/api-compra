package com.compra.apicompra.service;

import com.compra.apicompra.model.Entrega;
import com.compra.apicompra.model.StatusEntrega;
import com.compra.apicompra.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.codec.EncodingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private BuscarService buscarService;

    private EntregaRepository entregaRepository;

    @Transactional
    public  void finalizar(long entregaId){
        Entrega entrega = buscarService.buscar(entregaId);
        entrega.finalizar();
        entregaRepository.save(entrega);
    }

}
