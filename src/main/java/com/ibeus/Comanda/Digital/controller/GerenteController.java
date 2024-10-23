package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.service.GerenteService;
import com.ibeus.Comanda.Digital.model.Gerente;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    // Endpoint para criar um novo gerente
    @PostMapping
    public Gerente criarGerente(@RequestBody Gerente gerente) {
        return gerenteService.salvarGerente(gerente);
    }



    // @PutMapping("/pedido/{id}/status")
    // public void mudarStatusPedido(@PathVariable Long id, @RequestParam String novoStatus) {
    //     gerenteService.mudarStatusPedido(id, novoStatus);
    // }
}
