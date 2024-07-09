package com.riwi.Workshop_01_book.infraestructure.services;

import com.riwi.Workshop_01_book.api.dto.request.ReservationRequest;
import com.riwi.Workshop_01_book.api.dto.response.ReservationResponse;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
    @Override
    public ReservationResponse create(ReservationRequest request) {
        return null;
    }

    @Override
    public ReservationResponse get(Long aLong) {
        return null;
    }

    @Override
    public List<ReservationResponse> getAll() {
        return null;
    }

    @Override
    public ReservationResponse update(Long aLong, ReservationRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<ReservationResponse> findByUserId(Long userId) {
        return null;
    }

    @Override
    public List<ReservationResponse> findByBookId(Long bookId) {
        return null;
    }
}
