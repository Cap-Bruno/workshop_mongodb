package com.capgemini.workshopmongo.resources;

import com.capgemini.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User bruno = new User("1", "Bruno GR", "bruno@email.com");
        User pedro = new User("1", "Pedro SP", "pedro@email.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(bruno, pedro));
        return ResponseEntity.ok().body(list);
    }
}
