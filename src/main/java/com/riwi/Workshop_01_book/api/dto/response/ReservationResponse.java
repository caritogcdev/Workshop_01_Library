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
public class ReservationResponse {
    private Long id;
    private LocalDate reservationDate;
    private Boolean status;

    //Relationships
    private UserBasicResponse userId;
    private BookToReservationResponse bookId;

}
