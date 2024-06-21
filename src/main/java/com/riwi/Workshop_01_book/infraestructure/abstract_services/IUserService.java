package com.riwi.Workshop_01_book.infraestructure.abstract_services;

import com.riwi.Workshop_01_book.api.dto.request.UserRequest;
import com.riwi.Workshop_01_book.api.dto.response.UserResponse;

public interface IUserService extends GenericService<UserRequest, UserResponse, Long>{
}
