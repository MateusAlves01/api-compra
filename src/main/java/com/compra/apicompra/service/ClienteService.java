package com.compra.apicompra.service;

import com.compra.apicompra.exceptionhandler.EntregaException;
import com.compra.apicompra.exceptionhandler.ServiceException;
import com.compra.apicompra.model.Cliente;
import com.compra.apicompra.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente buscar(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntregaException("Cliente não encontrado"));
    }
    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso =  clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
        if(emailEmUso){
            throw new ServiceException("Já existe um cliente cadastrado com esse e-mail");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void exluir(Long id){
        clienteRepository.deleteById(id);
    }

}