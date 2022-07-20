package com.esample.springrest.service;

import com.esample.springrest.entities.BankUser;
import com.esample.springrest.entities.RetailerUser;
import com.esample.springrest.entities.User;
import com.esample.springrest.model.BankInput;
import com.esample.springrest.repository.BankRepository;
import com.esample.springrest.repository.RetailerRepository;
import com.esample.springrest.repository.UserRepository;
import com.esample.springrest.response.UserBankFetchResponse;
import com.esample.springrest.response.BankResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BankService {


    @Autowired
    BankRepository bankRepository;

    @Autowired
    RetailerRepository retailerRepository;

    public BankResponse validate(BankInput bankInput) {
        try {

            if (bankInput.getAccount_no() == null || bankInput.getAccount_no().equals("")) {
                return new BankResponse("Failure", "Account number not valid");
            }
            if (bankInput.getBranch_name() == null || bankInput.getBranch_name().equals("")) {
                return new BankResponse("Failure", "Branch name not valid");
            }
            if (bankInput.getIfsc_code() == null || bankInput.getIfsc_code().equals("")) {
                return new BankResponse("Failure", "Ifsc code not valid");
            }
            BankUser bankUser = new BankUser();
            bankUser.setUserId(bankInput.getUser_id());
            bankUser.setAccountNo(bankInput.getAccount_no());
            bankUser.setBranchName(bankInput.getBranch_name());
            bankUser.setIfscCode(bankInput.getIfsc_code());
            BankUser userReturned = bankRepository.save(bankUser);
            return new BankResponse("SUCCESS", "Successfully signed up.");
        } catch (Exception ex) {
            return new BankResponse("FAILURE","Error during signing up.");

        }

    }

//    public UserBankFetchResponse findByPhoneNumber(String phoneNumber) {
//        try {
//            RetailerUser retailerUser = retailerRepository.findByPhoneNum(phoneNumber);
//            if(retailerUser!= null) {
//                int userId = retailerUser.getId();
//                BankUser bankUser = bankRepository.findByUserId(userId);
//                if(bankUser!=null) {
//                    UserBankFetchResponse bankFetchResponse = new UserBankFetchResponse();
//                    bankFetchResponse.setBranchname(bankUser.getBranchName());
//                    bankFetchResponse.setEmail(retailerUser.getAadharNumber());
//                    bankFetchResponse.setIfsccode(bankUser.getIfscCode());
//                    bankFetchResponse.setAdharcard(retailerUser.getAccountNumber());
//                    bankFetchResponse.setPancard(retailerUser.getPanNumber());
//                    bankFetchResponse.setAccountnumber(bankUser.getAccountNo());
//                    bankFetchResponse.setId(bankUser.getId());
//                    bankFetchResponse.setMessage("Successfully fetched user details.");
//                    return bankFetchResponse;
//                }
//            }
//
//            return new UserBankFetchResponse();
//        } catch (Exception ex) {
//            return new UserBankFetchResponse();
//
//        }
//
//    }
}
