package com.celin.sitecelin.controller;

import com.celin.sitecelin.entities.users.User;
import com.celin.sitecelin.model.dto.users.UserDetails;
import com.celin.sitecelin.model.dto.users.UserModelDto;
import com.celin.sitecelin.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  private UserService service;

  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<UserModelDto>> getUser() {
    return ResponseEntity.ok(service.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDetails> getUserById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getUserById(id));
  }

  @PostMapping
  public ResponseEntity<User> postUser(@RequestBody String data) throws JsonProcessingException {
    return ResponseEntity.ok(service.postNewUser(data));
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@RequestBody String data, @PathVariable Long id) throws IOException {
    return ResponseEntity.ok(service.updateUser(id, data));
  }

}
