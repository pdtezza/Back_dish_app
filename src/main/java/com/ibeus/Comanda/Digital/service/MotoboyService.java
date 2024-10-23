package com.ibeus.Comanda.Digital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Motoboy;
import com.ibeus.Comanda.Digital.repository.MotoboyRepository;

import java.util.Optional;

@Service
public class MotoboyService {

    @Autowired
    private MotoboyRepository motoboyRepository;

 

    // Salvar um motoboy
    public Motoboy salvarMotoboy(Motoboy motoboy) {
        return motoboyRepository.save(motoboy);
    }

    // Buscar um motoboy por ID
    public Optional<Motoboy> buscarMotoboyPorId(Long id) {
        return motoboyRepository.findById(id);
    }

    // Finalizar entrega de um pedido
//     public void finalizarEntrega(Long idPedido) {
//         Pedido pedido = pedidoRepository.findById(idPedido)
//                 .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
//         pedido.setStatus("Entregue");
//         pedidoRepository.save(pedido);
//     }
}
