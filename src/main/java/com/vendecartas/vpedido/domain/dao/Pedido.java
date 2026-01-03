package com.vendecartas.vpedido.domain.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "pedidos")
public class Pedido {
    
    @Id
    private Long id;
    private String descricao;
    private Double valor;

}
