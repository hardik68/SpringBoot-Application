package com.esample.springrest.controller;

import com.esample.springrest.model.RetailerInput;
import com.esample.springrest.response.RetailerResponse;
import com.esample.springrest.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetalierController {

    @Autowired(required = true)
    private RetailerService retailerService;

    @PostMapping("/retailOnboard")
    public RetailerResponse retailerOnboard(@RequestBody RetailerInput retailerInput) {

        return retailerService.retailerOnboard(retailerInput);
    }
}
