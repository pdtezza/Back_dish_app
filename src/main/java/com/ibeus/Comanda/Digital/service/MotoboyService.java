package com.ibeus.Comanda.Digital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Motoboy;
import com.ibeus.Comanda.Digital.model.Pedido;
import com.ibeus.Comanda.Digital.repository.MotoboyRepository;
import com.ibeus.Comanda.Digital.repository.PedidoRepository;

@Service
public class MotoboyService {

    @Autowired
    private MotoboyRepository motoboyRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

 

    // Salvar um motoboy
    public Motoboy salvarMotoboy(Motoboy motoboy) {
        return motoboyRepository.save(motoboy);
    }

    
    public Optional<Motoboy> buscarMotoboyPorId(Long id) {
        return motoboyRepository.findById(id);
    }

    public void finalizarEntrega(Long idPedido) {
    Pedido pedido = pedidoRepository.findById(idPedido)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    
    pedido.setStatus("Entregue");
    pedidoRepository.save(pedido);
}

}
