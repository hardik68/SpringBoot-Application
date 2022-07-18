package com.esample.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esample.springrest.model.MobileNumberInput;
import com.esample.springrest.model.ValidateOtpRequest;
import com.esample.springrest.service.OtpService;


@RestController
public class OtpController {
	
	@Autowired(required=true)
	private OtpService otpService;
	
	@PostMapping("/generateotp")
	public String home(@RequestBody MobileNumberInput mobileNumberInput) {
		
		String otp =  otpService.genrateOtp(mobileNumberInput);
        return otp;
		
	}
	
	@PostMapping("/validateotp")
	public boolean validateOtp (@RequestBody ValidateOtpRequest validateOtpRequest) {
		
		boolean response = otpService.validateOtp(validateOtpRequest);
		
		return response;
		
	}

}

