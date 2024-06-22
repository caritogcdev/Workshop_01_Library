package com.riwi.Workshop_01_book.api.controllers;

import com.riwi.Workshop_01_book.api.dto.request.UserRequest;
import com.riwi.Workshop_01_book.api.dto.response.UserResponse;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController implements GenericController<UserRequest, UserResponse, Long>{
    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(
            @Validated @RequestBody UserRequest request) {

        return ResponseEntity.ok(this.userService.create(request));
    }

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<UserResponse> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @PutMapping(path = "/{userId}")
    @Override
    public ResponseEntity<UserResponse> update(
            @Validated @RequestBody UserRequest request,
            @PathVariable Long userId) {
        return ResponseEntity.ok(this.userService.update(userId, request));
    }

    @DeleteMapping(path = "/{userId}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable Long userId) {
        this.userService.delete(userId);
        return ResponseEntity.noContent().build();
    }
}
