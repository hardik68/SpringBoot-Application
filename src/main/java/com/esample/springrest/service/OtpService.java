package com.esample.springrest.service;

import com.esample.springrest.model.MobileNumberInput;
import com.esample.springrest.model.ValidateOtpRequest;

public interface OtpService {
	 String genrateOtp(MobileNumberInput mobileNumberInput);
	 
	boolean validateOtp(ValidateOtpRequest validateOtpRequest);

}
