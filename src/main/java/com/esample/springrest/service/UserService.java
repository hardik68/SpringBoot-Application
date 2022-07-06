package com.esample.springrest.service;

import com.esample.springrest.entities.User;
import com.esample.springrest.model.UserInputRequest;
import com.esample.springrest.response.UserFetchResponse;
import com.esample.springrest.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esample.springrest.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public UserResponse signUp(UserInputRequest userInputRequest) {
        try {
            User user = new User();
            user.setName(userInputRequest.getName());
            user.setEmail(userInputRequest.getEmail());
            user.setPhoneNum(userInputRequest.getPhone());
            User userReturned = userRepository.save(user);
            return new UserResponse(userReturned.getId(),"Successfully signed up.","SUCCESS");
        }catch (Exception ex) {
            return new UserResponse("Error during signing up.","FAILURE");
        }

    }

    public UserFetchResponse findByUserName(String userName) {

        try {
            User user = userRepository.findByName(userName);
            UserFetchResponse userFetchResponse = new UserFetchResponse();
            userFetchResponse.setName(user.getName());
            userFetchResponse.setEmail(user.getEmail());
            userFetchResponse.setPhoneNo(user.getPhoneNum());
            userFetchResponse.setId(user.getId());
            userFetchResponse.setMessage("Successfully fetched user details.");
            return userFetchResponse;
        } catch (Exception ex) {
            return new UserFetchResponse();

        }
    }
}
