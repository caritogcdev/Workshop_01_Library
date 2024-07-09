package com.riwi.Workshop_01_book.infraestructure.abstract_services;

import com.riwi.Workshop_01_book.api.dto.request.LoanRequest;
import com.riwi.Workshop_01_book.api.dto.response.LoanResponse;

import java.util.List;

public interface ILoanService extends GenericService<LoanRequest, LoanResponse, Long>{
    List<LoanResponse> findByUserId(Long userId);
}
