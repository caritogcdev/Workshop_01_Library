package com.riwi.Workshop_01_book.domain.repositories;

import com.riwi.Workshop_01_book.domain.entities.LoanEntity;
import com.riwi.Workshop_01_book.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Long> {
    //List<LoanEntity> findLoanByUser(UserEntity userId);
}
