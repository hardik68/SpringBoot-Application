package com.esample.springrest.service;


import com.esample.springrest.entities.RetailerUser;
import com.esample.springrest.model.RetailerInput;
import com.esample.springrest.repository.RetailerRepository;
import com.esample.springrest.response.RetailerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RetailerService {
    @Autowired
    RetailerRepository retailerRepository;


    public RetailerResponse retailerOnboard(RetailerInput retailerInput) {
        try {
            if (!isValidAadhaarNumber(retailerInput.getAdharcardNo())) {
                return new RetailerResponse("Failure", "Aadhar Number not valid");
            }
            if (retailerInput.getMobile_number() == null || retailerInput.getMobile_number().equals("")) {
                return new RetailerResponse("Failure", "Mobile Number not valid");
            }
            if (!isValidPanCardNo(retailerInput.getPanNo())) {
                return new RetailerResponse("Failure", "Pan Number not valid");
            }
            if (retailerInput.getEmail() == null || retailerInput.getEmail().equals("")) {
                return new RetailerResponse("Failure", "Pan Number not valid");
            }

            RetailerUser retailerUser = new RetailerUser();
            retailerUser.setCreatedAt(new Date(System.currentTimeMillis()));
            retailerUser.setUpdatedAt(new Date(System.currentTimeMillis()));
            retailerUser.setEmail(retailerInput.getEmail());
            retailerUser.setPanCard(retailerInput.getPanNo());
            retailerUser.setPhoneNum(retailerInput.getMobile_number());
            retailerUser.setAdharcard(retailerInput.getAdharcardNo());
            retailerUser.setFirst_name(retailerInput.getFirst_name());
            retailerUser.setLast_name(retailerInput.getLast_name());
            RetailerUser userReturned = retailerRepository.save(retailerUser);
            return new RetailerResponse("SUCCESS", "Successfully signed up.");
        } catch (Exception ex) {
            return new RetailerResponse("FAILURE", ex.getMessage());
        }
    }
        public static boolean isValidPanCardNo(String panCardNo)
        {

            // Regex to check valid PAN Card number.
            String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

            // Compile the ReGex
            Pattern p = Pattern.compile(regex);

            // If the PAN Card number
            // is empty return false
            if (panCardNo == null)
            {
                return false;
            }

            // Pattern class contains matcher() method
            // to find matching between given
            // PAN Card number using regular expression.
            Matcher m = p.matcher(panCardNo);

            // Return if the PAN Card number
            // matched the ReGex
            return m.matches();
        }
        public static boolean isValidAadhaarNumber(String aadhar)
        {
            // Regex to check valid Aadhaar number.
            String regex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";

            // Compile the ReGex
            Pattern p = Pattern.compile(regex);

            // If the string is empty
            // return false
            if (aadhar == null) {
                return false;
            }

            // Pattern class contains matcher() method
            // to find matching between given string
            // and regular expression.
            Matcher m = p.matcher(aadhar);

            // Return if the string
            // matched the ReGex
            return m.matches();
        }



    }

