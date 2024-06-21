package com.riwi.Workshop_01_book.domain.repositories;

import com.riwi.Workshop_01_book.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
