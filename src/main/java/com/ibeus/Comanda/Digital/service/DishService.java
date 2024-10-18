package com.ibeus.Comanda.Digital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibeus.Comanda.Digital.model.Dish;
import com.ibeus.Comanda.Digital.repository.DishRepository;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Dish findById(Long id) {
        return dishRepository.findById(id).orElseThrow(() -> new RuntimeException("Dish not found"));
    }

    public Dish create(Dish dish) {
        if (dish.getQuantity()>0) {dish.setStock(true);}
        return dishRepository.save(dish);}

    public Dish update(Long id, Dish dishDetails) {
        Dish dish = findById(id);
        dish.setName(dishDetails.getName());
        dish.setDescription(dishDetails.getDescription());
        dish.setPrice(dishDetails.getPrice());
        dish.setCategory(dishDetails.getCategory());
        dish.setQuantity(dishDetails.getQuantity());
        if (dish.getQuantity()>0) {dish.setStock(true);}
        if (dish.getQuantity()==0) {dish.setStock(false);}
        if (dish.getQuantity()<0) { throw new RuntimeException("Quantidade insuficiente");}
        return dishRepository.save(dish);
    }

    public void delete(Long id) {
        Dish dish = findById(id);
        dishRepository.delete(dish);
    }

    public Dish diminuirQuantidade(Long id, int valor) {
        Dish dish = findById(id);
        if (dish.getQuantity() - valor < 0) {
            throw new RuntimeException("Quantidade insuficiente");
        }
        dish.setQuantity(dish.getQuantity() - valor);
        if (dish.getQuantity() == 0) {
            dish.setStock(false);
        }
        return dishRepository.save(dish);
    }

    public Dish aumentarQuantidade(Long id, int valor) {
        if (valor <= 0){
            throw new RuntimeException("Quantidade inválida");
        }
        Dish dish = findById(id);
        dish.setQuantity(dish.getQuantity() + valor);
        if (dish.getQuantity() > 0) {
            dish.setStock(true);
        }
        return dishRepository.save(dish);
    }

}