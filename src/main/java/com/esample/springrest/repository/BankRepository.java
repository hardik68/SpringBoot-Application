package com.esample.springrest.repository;

import com.esample.springrest.entities.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankUser,Integer> {
    BankUser findByUserId(int userId);
}
