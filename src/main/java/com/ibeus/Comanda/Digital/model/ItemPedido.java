package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Table(name = "itempedido")
@Data
@EqualsAndHashCode(exclude = {"itens"})
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "dishes_id")
    private Dish dish;

    private int quantidade;

    public ItemPedido() {}
    public ItemPedido(Dish dish, int quantidade) {
        this.dish = dish;
        this.quantidade = quantidade;
    }
}