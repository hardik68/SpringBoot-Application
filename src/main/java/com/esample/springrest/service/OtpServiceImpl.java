package com.esample.springrest.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.esample.springrest.model.EmailInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.esample.springrest.entities.UserOtp;
import com.esample.springrest.model.ValidateOtpRequest;
import com.esample.springrest.repository.UserOtpRepository;
@Service
public class OtpServiceImpl implements OtpService {
	@Autowired(required = true)
	private UserOtpRepository otpRepository;

	@Value("${otp.expiry.time}")
	private int expiryTime;

	private String getRandomNumberint() {
		// It will generate 4 digit random Number.
		// from 1000 to 9999
		Random rnd = new Random();
		int number = rnd.nextInt(9999);
		//int number = 1;


		// this will convert any number sequence into 4 character.
		return String.format("%04d", number);
	}


	public String genrateOtp(EmailInput emailInput) {
		String otp = getRandomNumberint();
		UserOtp userOtp = new UserOtp();
		if(isValidEmail(emailInput.getEmail())){
			userOtp.setEmail(emailInput.getEmail());
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			java.sql.Date expiryDate = new java.sql.Date(System.currentTimeMillis() + expiryTime);

			userOtp.setExpiryTime(expiryDate);
			userOtp.setGenratedAt(date);
			userOtp.setOtp(otp);

			otpRepository.save(userOtp);
			Map<String, String> otpStorageMap = new HashMap<>();
			otpStorageMap.put(emailInput.getEmail(), otp);
			return otp;
		}
		else{
			return "Not a valid Email";
		}
	}

	public boolean validateOtp(ValidateOtpRequest validateOtpRequest) {

		//fetching generated otp using phone no
		System.out.println("### Request ##" + validateOtpRequest.getOtp() + " " + validateOtpRequest.getMobileNumber());
		UserOtp userOtp = otpRepository.findByOtpAndMobileNumber(validateOtpRequest.getOtp(), validateOtpRequest.getMobileNumber());

		if (userOtp != null)
			System.out.println("### Response ###" + userOtp.getOtp() + " " + userOtp.getMobileNumber());
		if(null != userOtp && userOtp.getOtp().equals(validateOtpRequest.getOtp()))
			return true;
		else
			return false;
		//compare  request otp and already generated otp
		//logic time validation , otp validation
		//return true;
		// }else {
		//	 return false;
		// }
		//RESPONSE
		//SAME sUCCES VALIDATE IF  FAILED

		//return true;
//
	}

	public static boolean isValidMobileNo(String str) {
//(0/91): number starts with (0/91)
//[7-9]: starting of the number may contain a digit between 0 to 9
//[0-9]: then contains digits 0 to 9
		Pattern ptrn = Pattern.compile(
		"^[0-9]{10}$"

);
//the matcher() method creates a matcher that will match the given input against this pattern
		Matcher match = ptrn.matcher(str);
//returns a boolean value
		return (match.find() && match.group().equals(str));
	}
	public static boolean isValidEmail(String email) {
		//(0/91): number starts with (0/91)
		//[7-9]: starting of the number may contain a digit between 0 to 9
		//[0-9]: then contains digits 0 to 9
		Pattern ptrn = Pattern.compile(
				"^(.+)@(\\S+)$"

		);
		//the matcher() method creates a matcher that will match the given input against this pattern
		Matcher match = ptrn.matcher(email);
		//returns a boolean value
		return (match.find() && match.group().equals(email));
	}



}
