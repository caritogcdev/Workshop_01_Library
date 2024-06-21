package com.riwi.Workshop_01_book.api.controllers;

import com.riwi.Workshop_01_book.api.dto.request.UserRequest;
import com.riwi.Workshop_01_book.api.dto.response.UserResponse;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController implements GenericController<UserRequest, UserResponse, Long>{
    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(
            @RequestBody UserRequest request) {

        return ResponseEntity.ok(this.userService.create(request));
    }

    @Override
    public ResponseEntity<UserResponse> get(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> update(UserRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }
}
