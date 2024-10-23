package com.ibeus.Comanda.Digital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Gerente;
import com.ibeus.Comanda.Digital.repository.GerenteRepository;

import java.util.Optional;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    
    

    
    public Gerente salvarGerente(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    // Buscar um gerente por ID
    public Optional<Gerente> buscarGerentePorId(Long id) {
        return gerenteRepository.findById(id);
    }

    // Atualizar o status de um pedido
    // public void mudarStatusPedido(Long idPedido, String novoStatus) {
    //     Pedido pedido = pedidoRepository.findById(idPedido)
    //             .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    //     pedido.setStatus(novoStatus);
    //     pedidoRepository.save(pedido);
    // }
}
