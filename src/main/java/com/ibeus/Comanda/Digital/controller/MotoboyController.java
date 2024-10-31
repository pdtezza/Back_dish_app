package com.ibeus.Comanda.Digital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibeus.Comanda.Digital.model.Motoboy;
import com.ibeus.Comanda.Digital.service.MotoboyService;

@RestController
@RequestMapping("/motoboy")
public class MotoboyController {

    @Autowired
    private MotoboyService motoboyService;
   


    @PostMapping
    public Motoboy criarMotoboy(@RequestBody Motoboy motoboy) {
        return motoboyService.salvarMotoboy(motoboy);
    }
   

    @GetMapping("/{id}")
    public Optional<Motoboy> buscarMotoboyPorId(@PathVariable Long id) {
        return motoboyService.buscarMotoboyPorId(id);
    }
  @PostMapping("/pedidos/{idPedido}/finalizar")
public ResponseEntity<String> finalizarPedido(@PathVariable Long idPedido) {

    motoboyService.finalizarEntrega(idPedido);
    return ResponseEntity.ok("Pedido finalizado com sucesso.");

}
}
