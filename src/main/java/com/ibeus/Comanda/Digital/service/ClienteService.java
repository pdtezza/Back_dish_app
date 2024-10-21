package com.ibeus.Comanda.Digital.service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Cliente;
import com.ibeus.Comanda.Digital.model.Pedido;
import com.ibeus.Comanda.Digital.repository.ClienteRepository;

@Service
public class ClienteService {

    private final Map<Long, Pedido> pedidosSimulados = new HashMap<>();
    
    public ClienteService() {
        
        pedidosSimulados.put(1L, new Pedido(1L, "Pizza"));
        pedidosSimulados.put(2L, new Pedido(2L, "Hamburguer"));
        pedidosSimulados.put(3L, new Pedido(3L, "Batata"));
    }
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }


    public String acompanharPedido(Long pedidoId) {
        Pedido pedido = pedidosSimulados.get(pedidoId);
        if (pedido != null) {
            return "Pedido " + pedidoId + ": " + pedido.getDescricao() + ", Status: " + pedido.getStatus();
        } else {
            return "Pedido não encontrado.";
        }
    }

    
    public String avancarStatusPedido(Long pedidoId) {
        Pedido pedido = pedidosSimulados.get(pedidoId);
        if (pedido != null && !pedido.isFinalizado()) {
            pedido.avancarStatus();
            return "Status do pedido " + pedidoId + " atualizado para: " + pedido.getStatus();
        } else if (pedido.isFinalizado()) {
            return "O pedido já foi entregue.";
        } else {
            return "Pedido não encontrado.";
        }
    }

    
    public String retrocederStatusPedido(Long pedidoId) {
        Pedido pedido = pedidosSimulados.get(pedidoId);
        if (pedido != null && !pedido.isRecebido()) {
            pedido.retrocederStatus();
            return "Status do pedido " + pedidoId + " atualizado para: " + pedido.getStatus();
        } else if (pedido.isRecebido()) {
            return "O pedido está no status inicial e não pode ser retrocedido.";
        } else {
            return "Pedido não encontrado.";
        }
    }

    
    public Map<Long, Pedido> listarPedidosSimulados() {
        return pedidosSimulados;
    }
 }