package com.esample.springrest.service;


import com.esample.springrest.entities.RetailerUser;
import com.esample.springrest.model.RetailerInput;
import com.esample.springrest.repository.RetailerRepository;
import com.esample.springrest.response.RetailerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class RetailerService {
    @Autowired
    RetailerRepository retailerRepository;


    public RetailerResponse retailerOnboard(RetailerInput retailerInput) {
        try {
            if (retailerInput.getAdharcardNo() == null || retailerInput.getAdharcardNo().equals("")) {
                return new RetailerResponse("Failure", "Aadhar Number not valid");
            }
            if (retailerInput.getMobile_number() == null || retailerInput.getMobile_number().equals("")) {
                return new RetailerResponse("Failure", "Mobile Number not valid");
            }
            if (retailerInput.getPanNo() == null || retailerInput.getPanNo().equals("")) {
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
        }catch (Exception ex) {
            return new RetailerResponse("FAILURE",ex.getMessage());
        }


        }


    }

