package com.esample.springrest.controller;

import com.esample.springrest.model.KycInput;
import com.esample.springrest.response.KycResponse;
import com.esample.springrest.response.UserResponse;
import com.esample.springrest.service.KycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KycController {
    @Autowired(required = true)
    public KycService kycService;
    public KycResponse kycForm(@RequestBody KycInput kycInput){
        return kycService.kycForm(kycInput);
    }
}
