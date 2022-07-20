package com.esample.springrest.service;


import com.esample.springrest.entities.AddUser;
import com.esample.springrest.entities.RetailerUser;
import com.esample.springrest.model.AddressInput;
import com.esample.springrest.repository.AddressRepository;
import com.esample.springrest.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            AddUser userReturned = addressRepository.save(addUser);
            return new AddressResponse("SUCCESS", "Successfully signed up.");
        } catch (Exception ex) {
            return new AddressResponse("FAILURE", ex.getMessage());
        }

    }
}