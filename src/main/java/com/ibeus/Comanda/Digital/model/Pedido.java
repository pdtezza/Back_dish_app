package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemPedido> itens = new ArrayList<>();


    public void addItem(ItemPedido item) {
        this.itens.add(item);
    }

}
