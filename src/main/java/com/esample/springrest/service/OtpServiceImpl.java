package com.esample.springrest.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.esample.springrest.entities.UserOtp;
import com.esample.springrest.model.MobileNumberInput;
import com.esample.springrest.model.ValidateOtpRequest;
import com.esample.springrest.repository.UserOtpRepository;
@Service
public class OtpServiceImpl implements OtpService {
	@Autowired(required = true)
	private UserOtpRepository otpRepository;
	
	@Value("${otp.expiry.time}")
	private int expiryTime;
	private  String getRandomNumberint() {
	    // It will generate 4 digit random Number.
	    // from 1000 to 9999
	    Random rnd = new Random();
     int number = rnd.nextInt(9999);
	    //int number = 1;


	    // this will convert any number sequence into 4 character.
	    return String.format("%04d", number);
	}

	
	public String genrateOtp(MobileNumberInput mobileNumberInput) {
		String otp=getRandomNumberint();
		UserOtp userOtp=new UserOtp();
		userOtp.setMobileNumber(mobileNumberInput.getMobileNumber());
	      java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
	      java.sql.Date expiryDate=new java.sql.Date(System.currentTimeMillis()+expiryTime);

		userOtp.setExpiryTime(expiryDate);
		userOtp.setGenratedAt(date);
		userOtp.setOtp(otp);
		
	    otpRepository.save(userOtp);
		Map<String, String> otpStorageMap=new HashMap<>();
		otpStorageMap.put(mobileNumberInput.getMobileNumber(), otp);
			return otp;
	}
	
	public boolean validateOtp(ValidateOtpRequest validateOtpRequest) {

		//fetching generated otp using phone no
		System.out.println("### Request ##" + validateOtpRequest.getOtp() + " " + validateOtpRequest.getMobileNumber());
		UserOtp userOtp = otpRepository.findByOtpAndMobileNumber(validateOtpRequest.getOtp(), validateOtpRequest.getMobileNumber());

		if (userOtp != null)
			System.out.println("### Response ###" + userOtp.getOtp() + " " + userOtp.getMobileNumber());
		//compare  request otp and already generated otp 
		//logic time validation , otp validation
		//return true;
		// }else {
		//	 return false;
		// }
		//RESPONSE
		//SAME sUCCES VALIDATE IF  FAILED
		return true;
// if(userOtp.getOtp().equalsIgnoreCase(validateOtpRequest.getOtp()) && (userOtp.getExpiryTime()+300000 >System.currentTimeMillis())) {
	}

}
