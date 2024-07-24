package com.springBoot.relationships.controllers;

import com.springBoot.relationships.models.Cart;
import com.springBoot.relationships.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    public CartService service;

    @GetMapping("/all")
    public List<Cart> getAllCarts(){
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public Optional<Cart> getById(@PathVariable long id){
        return service.selectById(id);
    }

    @PostMapping("/bulk")
    public String createManyCarts(@RequestBody List<Cart> carts){
        return service.insertManyCarts(carts);
    }

    @PostMapping
    public String createCart(@RequestBody Cart cart){
        return service.insertCart(cart);
    }

    @PutMapping("/{id}")
    public String updateCart(@PathVariable long id, @RequestBody Cart cart){
        return service.updateCart(id, cart);
    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable long id){
        return service.deleteCart(id);
    }

}
