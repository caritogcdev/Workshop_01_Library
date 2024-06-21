package com.riwi.Workshop_01_book.infraestructure.services;

import com.riwi.Workshop_01_book.api.dto.request.UserRequest;
import com.riwi.Workshop_01_book.api.dto.response.UserResponse;
import com.riwi.Workshop_01_book.domain.entities.UserEntity;
import com.riwi.Workshop_01_book.domain.repositories.UserRepository;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.IUserService;
import com.riwi.Workshop_01_book.infraestructure.helpers.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;
    @Override
    public UserResponse create(UserRequest request) {
        //Transform request to entity
        UserEntity userEntity = this.userMapper.toUserEntity(request);
        return this.userMapper.toUserResponse(this.userRepository.save(userEntity));
    }

    @Override
    public UserResponse get(Long aLong) {
        return null;
    }

    @Override
    public UserResponse update(Long aLong, UserRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
