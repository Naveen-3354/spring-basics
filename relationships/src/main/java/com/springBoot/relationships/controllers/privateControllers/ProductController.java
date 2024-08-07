package com.springBoot.relationships.controllers.privateControllers;

import com.springBoot.relationships.models.entity.Product;
import com.springBoot.relationships.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    public final ProductService service;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable long id){
        return service.selectById(id);
    }

    @PostMapping("/bulk")
    public String createManyProducts(@RequestBody List<Product> products){
        return service.insertManyProducts(products);
    }

    @PostMapping
    public String createProduct(@RequestBody Product product){
        return service.insertProduct(product);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable long id, @RequestBody Product product){
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable long id){
        return service.deleteProduct(id);
    }

}
