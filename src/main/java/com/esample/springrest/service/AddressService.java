package com.esample.springrest.service;


import com.esample.springrest.entities.AddUser;
import com.esample.springrest.entities.RetailerUser;
import com.esample.springrest.model.AddressInput;
import com.esample.springrest.repository.AddressRepository;
import com.esample.springrest.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;


    public AddressResponse addressOnboard(AddressInput addressInput) {
        try {

            AddUser addUser = new AddUser();
            addUser.setAddressLine(addressInput.getAddressLine());

            addUser.setCity(addressInput.getCity());
            addUser.setState(addressInput.getState());
            addUser.setZipcode(addressInput.getZipcode());
            RestTemplate restTemplate = new RestTemplate();
            final String baseUrl = "https://api.postalpincode.in/pincode/"+ addressInput.getZipcode();
            URI uri = new URI(baseUrl);


            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

//Verify request succeed
            if(result.getStatusCodeValue()==200){
                AddUser userReturned = addressRepository.save(addUser);
            }else {
                return new AddressResponse("FAILURE","Not a valid pincode");
            }
            return new AddressResponse("SUCCESS", "Successfully");
        } catch (Exception ex) {
            return new AddressResponse("FAILURE", ex.getMessage());
        }

    }
}