package com.esample.springrest.controller;

import com.esample.springrest.model.BankInput;
import com.esample.springrest.response.UserBankFetchResponse;
import com.esample.springrest.response.BankResponse;
import com.esample.springrest.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {

    @Autowired(required = true)
    private BankService bankService;

    @PostMapping("/bankDetails")
    public BankResponse saveBankDetails(@RequestBody BankInput bankInput) {

        return bankService.validate(bankInput);
    }
}
//        @GetMapping("/fetchBankDetails")
//        public UserBankFetchResponse findByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber){
//        return bankService.findByPhoneNumber(phoneNumber);
//    }

