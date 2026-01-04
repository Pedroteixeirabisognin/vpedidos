package com.vendecartas.vpedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendecartas.vpedido.domain.dao.Pedido;

@Repository
public interface PedidosRepository extends JpaRepository<Pedido, String> {

} 
