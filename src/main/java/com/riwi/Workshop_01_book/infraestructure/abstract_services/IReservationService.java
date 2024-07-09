package com.riwi.Workshop_01_book.infraestructure.abstract_services;

import com.riwi.Workshop_01_book.api.dto.request.ReservationRequest;
import com.riwi.Workshop_01_book.api.dto.response.ReservationResponse;

import java.util.List;

public interface IReservationService extends GenericService<ReservationRequest, ReservationResponse, Long>{
    List<ReservationResponse> findByUserId(Long userId);
    List<ReservationResponse> findByBookId(Long bookId);
}
