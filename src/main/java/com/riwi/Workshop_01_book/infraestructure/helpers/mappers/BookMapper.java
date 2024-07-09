package com.riwi.Workshop_01_book.infraestructure.helpers.mappers;

import com.riwi.Workshop_01_book.api.dto.request.BookRequest;
import com.riwi.Workshop_01_book.api.dto.response.BookResponse;
import com.riwi.Workshop_01_book.domain.entities.BookEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    BookEntity toBookEntity(BookRequest bookRequest);
    @InheritInverseConfiguration
    BookResponse toBookResponse(BookEntity bookEntity);
    List<BookResponse> BookListToResponseList(List<BookEntity> bookEntities);
}
