package com.example.demo.service;

import com.example.demo.module.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository ;

    UserServiceImp(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        User user = userRepository.findById(id).get() ;
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User AddUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User ModifyUser(User user,long id) {
        Optional<User> optuser = userRepository.findById(id);
        if(optuser.isPresent()){
            User existuser = optuser.get();
            existuser.setNom(user.getNom());
            existuser.setPrenom(user.getPrenom());
            return  userRepository.save(existuser);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
