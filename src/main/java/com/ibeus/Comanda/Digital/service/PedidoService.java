package com.ibeus.Comanda.Digital.service;

import com.ibeus.Comanda.Digital.model.Dish;
import com.ibeus.Comanda.Digital.model.ItemPedido;
import com.ibeus.Comanda.Digital.model.Pedido;
import com.ibeus.Comanda.Digital.repository.DishRepository;
import com.ibeus.Comanda.Digital.repository.ItemPedidoRepository;
import com.ibeus.Comanda.Digital.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Dish findByIdDish(Long id) {
        return dishRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido criarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public void delete(Long id) {
        Pedido pedido = findById(id);
        pedidoRepository.delete(pedido);
    }


/*Plano A*/
/*  public Pedido addItem(Long idpedido, Long idprato, int quantidade) {
        Dish dish = dishRepository.findById(idprato).orElseThrow();
        Pedido pedido = pedidoRepository.findById(idpedido).orElseThrow();
        *//*ItemPedido item = new ItemPedido(dish, quantidade)*//*;
  *//*      pedido.addItem(item);*//*
        List<Integer> ListaId = new ArrayList<>();
        Integer idPrato = dish.getId();
        Long LongIdPrato = idPrato.longValue();
        ListaId.add(dish.getId());
        pedido.setItens(ListaId);


        return pedidoRepository.save(pedido);}*/


/*Plano B*/
/*  public Pedido addItem(Long idpedido, Long idprato, int quantidade) {
        Dish dish = dishRepository.findById(idprato).orElseThrow();
        Pedido pedido = pedidoRepository.findById(idpedido).orElseThrow();
        List<Integer> ListaId = new ArrayList<>();
        Integer idPrato = dish.getId();
        Long LongIdPrato = idPrato.longValue();
        ListaId.add(dish.getId());
        pedido.setItens(ListaId);


        return pedidoRepository.save(pedido);
}*/
    public Pedido update(Long id, Pedido detalhesPedido) {
        Pedido pedido = findById(id);
        pedido.setDish(detalhesPedido.getDish());
        pedido.setStatus(detalhesPedido.getStatus());

        for (Dish x: pedido.getDish()){
            pedido.setPrecoTotal(pedido.getPrecoTotal() + x.getPrice());
        }

        return pedidoRepository.save(pedido);
    }
}
