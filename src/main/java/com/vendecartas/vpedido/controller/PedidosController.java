package com.vendecartas.vpedido.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vendecartas.vpedido.domain.dao.Pedido;
import com.vendecartas.vpedido.service.PedidosService;


@Controller
@RequestMapping("/pedidos")
public class PedidosController {
    
    private PedidosService pedidosService;

    public PedidosController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @PostMapping("/")
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        return pedidosService.salvarPedido(pedido);
    }

    @GetMapping("/")
    public ResponseEntity<List<Pedido>> obterPedidos() {
        return pedidosService.obterPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable String id) {
        return pedidosService.getPedido(id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPedido(@PathVariable String id) {
        return pedidosService.deletarPedido(id);
    }
    


}
