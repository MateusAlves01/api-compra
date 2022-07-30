package com.compra.apicompra.service;

import com.compra.apicompra.model.Cliente;
import com.compra.apicompra.model.Entrega;
import com.compra.apicompra.model.StatusEntrega;
import com.compra.apicompra.repository.ClienteRepository;
import com.compra.apicompra.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class EntregaService {

    private ClienteRepository clienteRepository;
    private EntregaRepository entregaRepository;

    private ClienteService clienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
}
