package com.compra.apicompra.exceptionhandler;

import com.compra.apicompra.repository.EntregaRepository;

public class EntidadeException extends ServiceException{

    private EntregaRepository entregaRepository;

    public EntidadeException(String message) {
        super(message);
    }
}
