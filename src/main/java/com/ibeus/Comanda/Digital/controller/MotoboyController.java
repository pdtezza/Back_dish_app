package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Motoboy;
import com.ibeus.Comanda.Digital.service.MotoboyService;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    // @PutMapping("/pedido/{id}/finalizar")
    // public void finalizarEntrega(@PathVariable Long id) {
    //     motoboyService.finalizarEntrega(id);
    // }
}
