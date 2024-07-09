package com.riwi.Workshop_01_book.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationToBookResponse {
    private Long id;
    private LocalDate reservationDate;
    private Boolean status;

    // User relationship -  User who made the reservation
    private UserBasicResponse userId;
}
