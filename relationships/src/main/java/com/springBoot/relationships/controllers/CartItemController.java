package com.springBoot.relationships.controllers;

import com.springBoot.relationships.models.CartItem;
import com.springBoot.relationships.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    @Autowired
    public CartItemService service;

    @GetMapping("/all")
    public List<CartItem> getAllCartItems(){
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public Optional<CartItem> getById(@PathVariable long id){
        return service.selectById(id);
    }

    @PostMapping("/bulk")
    public String createManyCartItems(@RequestBody List<CartItem> cartItems){
        return service.insertManyCartItems(cartItems);
    }

    @PostMapping
    public String createCartItem(@RequestBody CartItem cartItem){
        return service.insertCartItem(cartItem);
    }

    @PutMapping("/{id}")
    public String updateCartItem(@PathVariable long id, @RequestBody CartItem cartItem){
        return service.updateCartItem(id, cartItem);
    }

    @DeleteMapping("/{id}")
    public String deleteCartItem(@PathVariable long id){
        return service.deleteCartItem(id);
    }

}
