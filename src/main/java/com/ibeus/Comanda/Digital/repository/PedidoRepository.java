package com.ibeus.Comanda.Digital.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ibeus.Comanda.Digital.model.Cliente;
import com.ibeus.Comanda.Digital.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
   
}
