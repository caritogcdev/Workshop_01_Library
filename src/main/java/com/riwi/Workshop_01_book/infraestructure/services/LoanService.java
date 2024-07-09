package com.riwi.Workshop_01_book.infraestructure.services;

import com.riwi.Workshop_01_book.api.dto.request.LoanRequest;
import com.riwi.Workshop_01_book.api.dto.response.LoanResponse;
import com.riwi.Workshop_01_book.domain.entities.LoanEntity;
import com.riwi.Workshop_01_book.domain.entities.UserEntity;
import com.riwi.Workshop_01_book.domain.repositories.BookRepository;
import com.riwi.Workshop_01_book.domain.repositories.LoanRepository;
import com.riwi.Workshop_01_book.domain.repositories.UserRepository;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.ILoanService;
import com.riwi.Workshop_01_book.infraestructure.helpers.mappers.LoanMapper;
import com.riwi.Workshop_01_book.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {
    @Autowired
    LoanRepository loanRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LoanMapper loanMapper;

    @Override
    public LoanResponse create(LoanRequest request) {
        //Transform request to entity
        LoanEntity loanEntity = this.loanMapper.toLoanEntity(request);

        // Active loan when it's create
        loanEntity.setStatus(true);

        // Verify that a user and associated book exist
        loanEntity.setUserId(this.userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BadRequestException("userId")));
        loanEntity.setBookId(this.bookRepository.findById(request.getBookId())
                .orElseThrow(()-> new BadRequestException("bookId")));

        return this.loanMapper.toLoanResponse(this.loanRepository.save(loanEntity));
    }

    @Override
    public LoanResponse get(Long id) {

        LoanEntity loanEntity = this.loanRepository.findById(id)
                .orElseThrow( () -> new BadRequestException("Loan id is invalid"));

        return this.loanMapper.toLoanResponse(loanEntity);
    }

    @Override
    public List<LoanResponse> getAll() {
        return this.loanMapper.LoanListToResponseList(this.loanRepository.findAll());
    }

    @Override
    public LoanResponse update(Long id, LoanRequest request) {

        this.loanRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Loan id is invalid"));

        // Convert to entity
        LoanEntity loanEntity = this.loanMapper.toLoanEntity(request);

        loanEntity.setReturnDate(request.getReturnDate());
        // Get actually date
        LocalDate todayDate = LocalDate.now();
        loanEntity.setLoanDate(todayDate);
        loanEntity.setStatus(request.getStatus());

        return this.loanMapper.toLoanResponse(this.loanRepository.save(loanEntity));

    }

    @Override
    public void delete(Long id) {

        LoanEntity loanEntity = this.loanRepository.findById(id)
                .orElseThrow( () -> new BadRequestException("Loan id is invalid"));

        this.loanRepository.delete(loanEntity);

    }

    @Override
    public List<LoanResponse> findByUserId(Long userId) {
        return null;
    }

    /*
    @Override
    public List<LoanResponse> findByUserId(Long userId) {
        UserEntity userEntity = this.userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("userId"));
        return this.loanMapper.LoanListToResponseList(this.loanRepository.findLoanByUser(userEntity));
    }

     */
}
