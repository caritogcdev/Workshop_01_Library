package com.riwi.Workshop_01_book.api.controllers;

import com.riwi.Workshop_01_book.api.dto.request.UserRequest;
import com.riwi.Workshop_01_book.api.dto.response.UserBasicResponse;
import com.riwi.Workshop_01_book.api.dto.response.UserResponse;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController implements GenericController<UserRequest, UserBasicResponse, Long>{
    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseEntity<UserBasicResponse> create(
            @Validated @RequestBody UserRequest request) {

        return ResponseEntity.ok(this.userService.create(request));
    }

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<UserBasicResponse> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UserBasicResponse>> getAll(){
        return ResponseEntity.ok(this.userService.getAll());
    }

    @PutMapping(path = "/{userId}")
    @Override
    public ResponseEntity<UserBasicResponse> update(
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
