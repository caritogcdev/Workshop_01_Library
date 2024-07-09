package com.riwi.Workshop_01_book.infraestructure.services;

import com.riwi.Workshop_01_book.api.dto.request.UserRequest;
import com.riwi.Workshop_01_book.api.dto.response.UserBasicResponse;
import com.riwi.Workshop_01_book.domain.entities.UserEntity;
import com.riwi.Workshop_01_book.domain.repositories.UserRepository;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.IUserService;
import com.riwi.Workshop_01_book.infraestructure.helpers.mappers.UserMapper;
import com.riwi.Workshop_01_book.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;
    @Override
    public UserBasicResponse create(UserRequest request) {
        //Transform request to entity
        UserEntity userEntity = this.userMapper.toUserEntity(request);

        // Set empty lists
        userEntity.setLoans(new ArrayList<>());
        userEntity.setReservations(new ArrayList<>());

        return this.userMapper.toUserResponse(this.userRepository.save(userEntity));
    }

    @Override
    public UserBasicResponse get(Long id) {

        UserEntity userEntity =  this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User id is invalid"));

        return this.userMapper.toUserResponse(userEntity);
    }

    @Override
    public List<UserBasicResponse> getAll() {
        return this.userMapper.UserListToResponseList(this.userRepository.findAll());
    }

    @Override
    public UserBasicResponse update(Long id, UserRequest request) {

       this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User id is invalid"));

       // Convert to entity
       UserEntity userEntity = this.userMapper.toUserEntity(request);

       userEntity.setId(id);
       userEntity.setUsername(request.getUsername());
       userEntity.setPassword(request.getPassword());
       userEntity.setEmail(request.getEmail());
       userEntity.setFullName(request.getFullName());

        return this.userMapper.toUserResponse(this.userRepository.save(userEntity));
    }

    @Override
    public void delete(Long id) {

        UserEntity userEntity = this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User id is invalid"));

        this.userRepository.delete(userEntity);
    }

}
