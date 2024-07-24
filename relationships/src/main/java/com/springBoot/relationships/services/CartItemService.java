package com.springBoot.relationships.services;

import com.springBoot.relationships.models.CartItem;
import com.springBoot.relationships.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    public CartItemRepository repository;

    public String insertCartItem(CartItem cartItem) {
        repository.save(cartItem);
        return "CartItem added.";
    }

    public String insertManyCartItems(List<CartItem> cartItems) {
        repository.saveAll(cartItems);
        return "CartItems added.";
    }

    public List<CartItem> selectAll() {
        return repository.findAll();
    }

    public Optional<CartItem> selectById(long id) {
        return repository.findById(id);
    }

    public String updateCartItem(long id, CartItem cartItem) {
        Optional<CartItem> cartItemExist = repository.findById(id);
        if (cartItemExist.isPresent()) {
            CartItem existingCartItem = cartItemExist.get();
            repository.save(existingCartItem);
            return "CartItem Updated.";
        }
        return "cartItem does not exist.";
    }

    public String deleteCartItem(long id) {
        repository.deleteById(id);
        return "CartItem deleted.";
    }
}
