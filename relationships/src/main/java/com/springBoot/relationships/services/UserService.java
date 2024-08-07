package com.springBoot.relationships.services;

import com.springBoot.relationships.models.entity.User;
import com.springBoot.relationships.models.enums.UserRoles;
import com.springBoot.relationships.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository repository;

    public String insertUser(User user){
        user.setRoles(UserRoles.USER);
        user.setCreatedOn(LocalDate.now());
        repository.save(user);
        return "User added.";
    }

    public String insertManyUsers(List<User> users){
        repository.saveAll(users.stream().peek(x-> x.setCreatedOn(LocalDate.now())).peek(x->x.setRoles(UserRoles.USER)).toList());
        return "Users added.";
    }

    public List<User> selectAll(){
        return repository.findAll();
    }

    public Optional<User> selectById(long id){
        return repository.findById(id);
    }

    public String updateUser(long id, User user){
        Optional<User> userExist = repository.findById(id);
        if(userExist.isPresent()){
            User existingUser = userExist.get();
            existingUser.setEmail(user.getEmail());
            existingUser.setName(user.getName());
            existingUser.setNumber(user.getNumber());
            existingUser.setPassword(user.getPassword());
            repository.save(existingUser);
            return "User Updated.";
        }
        return "user does not exist.";
    }

    public String deleteUser(long id){
        repository.deleteById(id);
        return "User deleted.";
    }
}
