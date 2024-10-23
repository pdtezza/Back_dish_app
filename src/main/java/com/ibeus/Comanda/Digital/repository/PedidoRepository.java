package com.ibeus.Comanda.Digital.repository;

import com.ibeus.Comanda.Digital.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ibeus.Comanda.Digital.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
}
