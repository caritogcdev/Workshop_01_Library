package com.riwi.Workshop_01_book.api.controllers;

import com.riwi.Workshop_01_book.api.dto.request.LoanRequest;
import com.riwi.Workshop_01_book.api.dto.response.LoanResponse;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/loans")
public class LoanController implements GenericController<LoanRequest, LoanResponse, Long>{
    @Autowired
    ILoanService loanService;

    @PostMapping
    @Override
    public ResponseEntity<LoanResponse> create(
            @Validated @RequestBody LoanRequest request) {
        return ResponseEntity.ok(this.loanService.create(request));
    }

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<LoanResponse> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(loanService.get(id));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<LoanResponse>> getAll() {
        return ResponseEntity.ok(this.loanService.getAll());
    }

    @PutMapping(path = "/{id}")
    @Override
    public ResponseEntity<LoanResponse> update(
            @Validated @RequestBody LoanRequest request,
            @PathVariable Long id) {

        LoanRequest loanRequest = new LoanRequest();

        loanRequest.setStatus(request.getStatus());
        loanRequest.setReturnDate(request.getReturnDate());

        return ResponseEntity.ok(this.loanService.update(id, request));
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        this.loanService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
