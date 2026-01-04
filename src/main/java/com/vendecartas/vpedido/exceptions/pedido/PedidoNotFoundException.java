package com.vendecartas.vpedido.exceptions.pedido;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PedidoNotFoundException extends RuntimeException {
    public PedidoNotFoundException(String id) {
        super("Pedido com ID " + id + " não encontrado");
    }
}

