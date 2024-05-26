package com.example.esercizio_unit_test.services;

import com.example.esercizio_unit_test.entities.User;
import com.example.esercizio_unit_test.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepo.findById(id);
    }

    public User createUser(User user) {
        return userRepo.saveAndFlush(user);
    }

    public Optional<User> updateUser (Long id, User userDetails){
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            User userSaved = userRepo.saveAndFlush(user);
            return Optional.of(userSaved);
        }else{
            return Optional.empty();
        }
    }

    public boolean deleteUser(Long id){
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
