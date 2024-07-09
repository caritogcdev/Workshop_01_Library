package com.riwi.Workshop_01_book.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private LocalDate returnDate;
    @NotBlank(message = "Status is required")
    //@Size(min = 0, max = 20, message = "The Status field exceeds the number of characters")
    private Boolean status;

    private Long userId;
    private Long bookId;
}
