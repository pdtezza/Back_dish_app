package com.ibeus.Comanda.Digital.service;

import com.ibeus.Comanda.Digital.model.Dish;
import com.ibeus.Comanda.Digital.model.Pedido;
import com.ibeus.Comanda.Digital.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido criarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public Pedido additem(Long id, Dish detalhesPrato){
        Pedido pedido = findById(id);
        List<Dish> listaItens = pedido.getItens();
        listaItens.add(detalhesPrato);
        return pedidoRepository.save(pedido);

    }


}
