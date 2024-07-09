package com.riwi.Workshop_01_book.infraestructure.helpers.mappers;

import com.riwi.Workshop_01_book.api.dto.request.ReservationRequest;
import com.riwi.Workshop_01_book.api.dto.response.ReservationResponse;
import com.riwi.Workshop_01_book.domain.entities.ReservationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "bookId", ignore = true)
    ReservationEntity toReservationEntity(ReservationRequest reservationRequest);
    @InheritInverseConfiguration
    ReservationResponse toReservationResponse(ReservationEntity reservationEntity);

    List<ReservationResponse> ReservationToResponseList(List<ReservationEntity> reservationEntities);
}
