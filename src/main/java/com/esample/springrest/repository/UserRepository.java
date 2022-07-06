package com.esample.springrest.repository;

import com.esample.springrest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByName(String userName);

    User findByPhoneNum(String phoneNumber);
}
