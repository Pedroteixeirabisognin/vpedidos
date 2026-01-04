package com.vendecartas.vpedido.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vendecartas.vpedido.domain.dao.Pedido;
import com.vendecartas.vpedido.exceptions.pedido.PedidoNotFoundException;
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

    public ResponseEntity<List<Pedido>> obterPedidos() {
        return ResponseEntity.ok(pedidosRepository.findAll());
    }

    public ResponseEntity<Pedido> getPedido(String id) {

        Pedido pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));

        return ResponseEntity.ok(pedido);
    }
    
    public ResponseEntity<String> deletarPedido(String id) {
        return ResponseEntity.ok("Pedido com ID " + id + " deletado");
    }
}
