package com.vendecartas.vpedido.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.vendecartas.vpedido.domain.dao.Pedido;
import com.vendecartas.vpedido.exceptions.pedido.PedidoNotFoundException;
import com.vendecartas.vpedido.mensaging.event.PedidoCriadoEvent;
import com.vendecartas.vpedido.mensaging.producer.PedidoProducer;
import com.vendecartas.vpedido.repository.PedidosRepository;

@Service
public class PedidosService {
    
    private PedidosRepository pedidosRepository;
    private final PedidoProducer pedidoProducer;

    public PedidosService(PedidosRepository pedidosRepository,PedidoProducer pedidoProducer) {
        this.pedidosRepository = pedidosRepository;
        this.pedidoProducer = pedidoProducer;
    }

    @Transactional
    public ResponseEntity<Pedido> salvarPedido(Pedido pedido) {
        Pedido pedidoSalvo =  pedidosRepository.save(pedido);
        pedidoProducer.enviar(new PedidoCriadoEvent(
            pedidoSalvo.getId(),
            pedidoSalvo.getDescricao(),
            pedidoSalvo.getValor()
        ));
        return ResponseEntity.ok(pedido);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Pedido>> obterPedidos() {
        return ResponseEntity.ok(pedidosRepository.findAll());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Pedido> getPedido(String id) {

        Pedido pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));

        return ResponseEntity.ok(pedido);
    }
    
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ResponseEntity<String> deletarPedido(String id) {

        pedidosRepository.findById(id).orElseThrow(() -> new PedidoNotFoundException(id));
        pedidosRepository.deleteById(id);

        return ResponseEntity.ok("Pedido com ID " + id + " deletado");
    }
}
