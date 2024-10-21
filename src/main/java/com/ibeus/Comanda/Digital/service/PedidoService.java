package com.ibeus.Comanda.Digital.service;

import com.ibeus.Comanda.Digital.model.Dish;
import com.ibeus.Comanda.Digital.model.ItemPedido;
import com.ibeus.Comanda.Digital.model.Pedido;
import com.ibeus.Comanda.Digital.repository.DishRepository;
import com.ibeus.Comanda.Digital.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DishRepository dishRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Dish findByIdDish(Long id) {
        return dishRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido criarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public void delete(Long id) {
        Pedido pedido = findById(id);
        pedidoRepository.delete(pedido);
    }

//    public Pedido addItem(Long idpedido, Long idprato, int quantidade) {
//        Pedido pedido = findById(idpedido);
//        Dish dish = findByIdDish(idprato);
//
//        boolean pratoJaAdicionado = false;
//        for (ItemPedido item : pedido.getItens()) {
//            if (item.getDish().getId().equals(dish.getId())) {
//                item.setQuantidade(item.getQuantidade() + quantidade);
//                pratoJaAdicionado = true;
//                break;
//            }
//        }
//
//        if (!pratoJaAdicionado) {
//            ItemPedido item = new ItemPedido();
//            item.setPedido(pedido);
//            item.setDish(dish);
//            item.setQuantidade(quantidade);
//
//            pedido.getItens().add(item);
//        }
//
//        return pedidoRepository.save(pedido);
//    }

/*    public Pedido deletarItem(Long idpedido, String item){

        Pedido pedido = findById(idpedido);
        ArrayList<Dish> listaPratos = new ArrayList<>();
        listaPratos = pedido.getItens();

        for (Dish prato: listaPratos){
            if (prato.getName() == item){
                listaPratos.remove(item);
                break;
            }
        }
        return pedidoRepository.save(pedido);
    }*/


}
