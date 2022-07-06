package com.esample.springrest.repository;

import com.esample.springrest.entities.RetailerUser;
import com.esample.springrest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerRepository extends JpaRepository<RetailerUser,Integer> {

    RetailerUser findByPhoneNum(String phoneNumber);
}
