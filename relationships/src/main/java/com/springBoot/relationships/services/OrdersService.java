package com.springBoot.relationships.services;

import com.springBoot.relationships.models.Orders;
import com.springBoot.relationships.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    public OrdersRepository repository;
    
    public String insertOrders(Orders orders) {
        repository.save(orders);
        return "Orders added.";
    }

    public String insertManyOrderss(List<Orders> orderss) {
        repository.saveAll(orderss);
        return "Orderss added.";
    }

    public List<Orders> selectAll() {
        return repository.findAll();
    }

    public Optional<Orders> selectById(long id) {
        return repository.findById(id);
    }

    public String updateOrders(long id, Orders orders) {
        Optional<Orders> ordersExist = repository.findById(id);
        if (ordersExist.isPresent()) {
            Orders existingOrders = ordersExist.get();
            repository.save(existingOrders);
            return "Orders Updated.";
        }
        return "orders does not exist.";
    }

    public String deleteOrders(long id) {
        repository.deleteById(id);
        return "Orders deleted.";
    }
}
