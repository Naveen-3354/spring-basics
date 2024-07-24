package com.springBoot.relationships.controllers;

import com.springBoot.relationships.models.Orders;
import com.springBoot.relationships.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    public OrdersService service;

    @GetMapping("/all")
    public List<Orders> getAllOrderss(){
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getById(@PathVariable long id){
        return service.selectById(id);
    }

    @PostMapping("/bulk")
    public String createManyOrderss(@RequestBody List<Orders> orderss){
        return service.insertManyOrderss(orderss);
    }

    @PostMapping
    public String createOrders(@RequestBody Orders orders){
        return service.insertOrders(orders);
    }

    @PutMapping("/{id}")
    public String updateOrders(@PathVariable long id, @RequestBody Orders orders){
        return service.updateOrders(id, orders);
    }

    @DeleteMapping("/{id}")
    public String deleteOrders(@PathVariable long id){
        return service.deleteOrders(id);
    }

}
