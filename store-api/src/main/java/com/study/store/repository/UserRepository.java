package com.study.store.repository;

import com.study.store.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // query method
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndAccount(String account, String email);

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

    Optional<User> findByAccountAndPassword(String account, String password);
}
