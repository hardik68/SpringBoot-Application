package com.esample.springrest.service;

import com.esample.springrest.model.EmailInput;
import com.esample.springrest.model.MobileNumberInput;
import com.esample.springrest.model.ValidateOtpRequest;

public interface OtpService {
	 String genrateOtp(EmailInput emailInput
	 );
	 
	boolean validateOtp(ValidateOtpRequest validateOtpRequest);

}
