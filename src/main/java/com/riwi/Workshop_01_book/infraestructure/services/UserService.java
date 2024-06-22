package com.riwi.Workshop_01_book.infraestructure.services;

import com.riwi.Workshop_01_book.api.dto.request.UserRequest;
import com.riwi.Workshop_01_book.api.dto.response.UserResponse;
import com.riwi.Workshop_01_book.domain.entities.UserEntity;
import com.riwi.Workshop_01_book.domain.repositories.UserRepository;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.IUserService;
import com.riwi.Workshop_01_book.infraestructure.helpers.mappers.UserMapper;
import com.riwi.Workshop_01_book.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
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
    public UserResponse get(Long id) {

        UserEntity userEntity =  this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User id is invalid"));

        return this.userMapper.toUserResponse(userEntity);
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {

       this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User id is invalid"));

       // Convertimos a entidad
       UserEntity userEntity = this.userMapper.toUserEntity(request);
       userEntity.setId(id);

        return this.userMapper.toUserResponse(this.userRepository.save(userEntity));
    }

    @Override
    public void delete(Long id) {

        UserEntity userEntity = this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User id is invalid"));

        this.userRepository.delete(userEntity);
    }

}
