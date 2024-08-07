package com.springBoot.relationships.controllers.privateControllers;

import com.springBoot.relationships.models.entity.Address;
import com.springBoot.relationships.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    public final AddressService service;

    @GetMapping("/all")
    public List<Address> getAllAddresss(){
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public Optional<Address> getById(@PathVariable long id){
        return service.selectById(id);
    }

    @PostMapping("/bulk")
    public String createManyAddresss(@RequestBody List<Address> addresss){
        return service.insertManyAddresss(addresss);
    }

    @PostMapping
    public String createAddress(@RequestBody Address address){
        return service.insertAddress(address);
    }

    @PutMapping("/{id}")
    public String updateAddress(@PathVariable long id, @RequestBody Address address){
        return service.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable long id){
        return service.deleteAddress(id);
    }

}
