package com.capgemini.workshopmongo.service;

import com.capgemini.workshopmongo.domain.User;
import com.capgemini.workshopmongo.dto.UserDTO;
import com.capgemini.workshopmongo.repository.UserRepository;
import com.capgemini.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insertUser(User user){
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void deleteUser(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        User newObj = findById(user.getId());
        updateData(newObj, user);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User user) {
        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }
}
