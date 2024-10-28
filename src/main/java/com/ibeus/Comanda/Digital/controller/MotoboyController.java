package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Motoboy;
import com.ibeus.Comanda.Digital.service.MotoboyService;
import com.ibeus.Comanda.Digital.service.PedidoService;

import java.util.Optional;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
public ResponseEntity<String> finalizarPedido(@PathVariable Long idPedido, @RequestBody Map <String, String> payload) {
    String cpfParcial = payload.get("cpfParcial");

    if (cpfParcial == null) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parâmetro 'cpfParcial' é obrigatório.");
    }

    try {
        motoboyService.finalizarEntrega(idPedido, cpfParcial);
        return ResponseEntity.ok("Pedido finalizado com sucesso.");
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
}
