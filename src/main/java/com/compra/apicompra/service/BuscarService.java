package com.compra.apicompra.service;

import com.compra.apicompra.exceptionhandler.EntidadeException;
import com.compra.apicompra.exceptionhandler.EntregaException;
import com.compra.apicompra.model.Entrega;
import com.compra.apicompra.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscarService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long id){
        return entregaRepository.findById(id)
                .orElseThrow(() -> new EntidadeException("Entrega não encontrada."));
    }
}
