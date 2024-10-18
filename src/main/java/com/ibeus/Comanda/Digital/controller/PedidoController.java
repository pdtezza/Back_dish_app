package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Dish;
import com.ibeus.Comanda.Digital.model.Pedido;
import com.ibeus.Comanda.Digital.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PutMapping("/{id}/adicionarItemPedido")
    public Pedido adicionarItem(@PathVariable Long id,@RequestBody Dish prato){ return pedidoService.additem(id,prato); }
}
