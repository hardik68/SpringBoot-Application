package com.esample.springrest.repository;

import com.esample.springrest.entities.AddUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddUser,Integer> {
}
