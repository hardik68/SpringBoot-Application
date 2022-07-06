package com.esample.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esample.springrest.entities.UserOtp;


@Repository
public interface UserOtpRepository extends JpaRepository<UserOtp, Integer> { 
	UserOtp findByOtpAndMobileNumber(String otp,String mobileNumber);

}
