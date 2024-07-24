package com.springBoot.relationships.services;

import com.springBoot.relationships.models.Cart;
import com.springBoot.relationships.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    
    @Autowired
    public CartRepository repository;

    public String insertCart(Cart cart) {
        repository.save(cart);
        return "Cart added.";
    }

    public String insertManyCarts(List<Cart> cartItems) {
        repository.saveAll(cartItems);
        return "Carts added.";
    }

    public List<Cart> selectAll() {
        return repository.findAll();
    }

    public Optional<Cart> selectById(long id) {
        return repository.findById(id);
    }

    public String updateCart(long id, Cart cartItem) {
        Optional<Cart> cartItemExist = repository.findById(id);
        if (cartItemExist.isPresent()) {
            Cart existingCart = cartItemExist.get();
            repository.save(existingCart);
            return "Cart Updated.";
        }
        return "cartItem does not exist.";
    }

    public String deleteCart(long id) {
        repository.deleteById(id);
        return "Cart deleted.";
    }
}
