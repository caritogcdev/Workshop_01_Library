package com.riwi.Workshop_01_book.infraestructure.helpers.mappers;

import com.riwi.Workshop_01_book.api.dto.request.LoanRequest;
import com.riwi.Workshop_01_book.api.dto.response.LoanResponse;
import com.riwi.Workshop_01_book.domain.entities.LoanEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "bookId", ignore = true)
    LoanEntity toLoanEntity(LoanRequest loanRequest);
    @InheritInverseConfiguration
    LoanResponse toLoanResponse(LoanEntity loanEntity);
    List<LoanResponse> LoanListToResponseList(List<LoanEntity> loanEntities);
}
