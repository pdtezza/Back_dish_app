package com.ibeus.Comanda.Digital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibeus.Comanda.Digital.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    Optional<Pedido> findTopByClienteIsNullOrderByIdDesc();
}
