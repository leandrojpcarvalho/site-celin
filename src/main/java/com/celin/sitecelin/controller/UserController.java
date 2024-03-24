package com.celin.sitecelin.controller;

import com.celin.sitecelin.entities.User;
import com.celin.sitecelin.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.coyote.BadRequestException;
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
  public ResponseEntity<List<User>> getUser() {
    return ResponseEntity.ok(service.getAllUsers());
  }

  @PostMapping
  public ResponseEntity<User> postUser(@RequestBody String data) throws JsonProcessingException {
    return ResponseEntity.ok(service.postNewUser(data));
  }

  @PutMapping("/{name}")
  public ResponseEntity<User> updateUser(@RequestBody String data, @PathVariable String name) throws IOException {
    return ResponseEntity.ok(service.updateUser(name, data));
  }

}
