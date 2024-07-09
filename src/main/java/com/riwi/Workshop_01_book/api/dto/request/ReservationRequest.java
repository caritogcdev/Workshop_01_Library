package com.riwi.Workshop_01_book.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    @NotBlank(message = "Reservation Date is required")
    private LocalDate reservationDate;
    @NotBlank(message = "Status Date is required")
    private Boolean status;

    private Long userId;
    private Long bookId;
}
