package com.riwi.Workshop_01_book.infraestructure.helpers.mappers;

import com.riwi.Workshop_01_book.api.dto.request.UserRequest;
import com.riwi.Workshop_01_book.api.dto.response.UserBasicResponse;
import com.riwi.Workshop_01_book.domain.entities.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    UserEntity toUserEntity(UserRequest userRequest);

    @InheritInverseConfiguration
    UserBasicResponse toUserResponse(UserEntity userEntity);

    List<UserBasicResponse> UserListToResponseList(List<UserEntity> userEntities);

}
