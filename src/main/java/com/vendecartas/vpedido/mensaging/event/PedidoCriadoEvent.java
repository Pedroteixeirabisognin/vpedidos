package com.vendecartas.vpedido.mensaging.event;

public record PedidoCriadoEvent(
    String id,
    String descricao,
    Double valor
) {}
