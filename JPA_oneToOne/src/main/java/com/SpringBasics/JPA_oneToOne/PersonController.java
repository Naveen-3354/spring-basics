package com.SpringBasics.JPA_oneToOne;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    public PersonRepository repository;

    @GetMapping
    public List<Person> getAllPersons(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersons(@PathVariable long id){
        return repository.findById(id);
    }

    @PostMapping
    public String insertPerson(@RequestBody Person person){
        repository.save(person);
        return "Person added.";
    }

    @PutMapping("/{id}")
    public String updatePerson(@PathVariable long id,@RequestBody Person person){
        Optional<Person> person1 = repository.findById(id);
        if (person1.isPresent()) {
            person1.get().setName(person.getName());
            person1.get().setPassport(person.getPassport());
            repository.save(person1.get()); 
        }
        return "Person updated.";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        repository.deleteById(id);
        return "peerson delete0d.";
    }
}
