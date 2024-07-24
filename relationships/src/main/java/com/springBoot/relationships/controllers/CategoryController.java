package com.springBoot.relationships.controllers;

import com.springBoot.relationships.models.Category;
import com.springBoot.relationships.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    public CategoryService service;

    @GetMapping("/all")
    public List<Category> getAllCategorys(){
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable long id){
        return service.selectById(id);
    }

    @PostMapping("/bulk")
    public String createManyCategorys(@RequestBody List<Category> categorys){
        return service.insertManyCategorys(categorys);
    }

    @PostMapping
    public String createCategory(@RequestBody Category category){
        return service.insertCategory(category);
    }

    @PutMapping("/{id}")
    public String updateCategory(@PathVariable long id, @RequestBody Category category){
        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable long id){
        return service.deleteCategory(id);
    }

}
