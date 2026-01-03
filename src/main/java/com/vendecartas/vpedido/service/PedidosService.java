package com.vendecartas.vpedido.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vendecartas.vpedido.domain.dao.Pedido;
import com.vendecartas.vpedido.repository.PedidosRepository;

@Service
public class PedidosService {
    
    private PedidosRepository pedidosRepository;

    public PedidosService(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    public ResponseEntity<Pedido> salvarPedido(Pedido pedido) {
        
        return ResponseEntity.ok(pedidosRepository.save(pedido));
    }

    public ResponseEntity<String> obterPedidos() {
        return ResponseEntity.ok("Lista de pedidos");
    }

    public ResponseEntity<String> getPedido(String id) {
        return ResponseEntity.ok("Pedido com ID: " + id);
    }
    
    public ResponseEntity<String> deletarPedido(String id) {
        return ResponseEntity.ok("Pedido com ID " + id + " deletado");
    }
}
