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
public class LoanToBookResponse {
    private Long id;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private Boolean status;

    // User relationship -  User who made the loan
    private UserBasicResponse userId;
}
