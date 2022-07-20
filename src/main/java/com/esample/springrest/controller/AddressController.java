package com.esample.springrest.controller;

import com.esample.springrest.model.AddressInput;
import com.esample.springrest.response.AddressResponse;
import com.esample.springrest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired(required = true)
    private AddressService addressService;

    @PostMapping("/addressOnboard")
    public AddressResponse addressOnboard(@RequestBody AddressInput addressInput){
        return addressService.addressOnboard(addressInput);
    }
}
