package com.esample.springrest.service;

import com.esample.springrest.entities.User;
import com.esample.springrest.model.UserInputRequest;
import com.esample.springrest.response.UserFetchResponse;
import com.esample.springrest.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esample.springrest.repository.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    private CharSequence str;

    public UserResponse signUp(UserInputRequest userInputRequest) {
        try {
            User user = new User();
            user.setName(userInputRequest.getName());
            if(isValidEmail(userInputRequest.getEmail()))
                user.setEmail(userInputRequest.getEmail());
            else
                return new UserResponse("Error during signing up. Invalid Email","FAILURE");
            if(isValidMobileNo(userInputRequest.getPhone()))
               user.setPhoneNum(userInputRequest.getPhone());
            else
                return new UserResponse("Error during signing up. Invalid Phone No","FAILURE");
            user.setStoreName(userInputRequest.getStoreName());
            user.setRetailer(userInputRequest.isRetailer());
            user.setApprover(userInputRequest.isApprover());
            if(user.isApprover()) {
                user.setUserName(userInputRequest.getUserName());
                user.setUserPassword(userInputRequest.getPassword());
            }
            user.setUserverified(false);
            User userReturned = userRepository.save(user);
            return new UserResponse(userReturned.getId(),"Successfully signed up.","SUCCESS");
        }catch (Exception ex) {
            return new UserResponse("Error during signing up. " +ex.getMessage(),"FAILURE");
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

    public static boolean isValidMobileNo(String mobileNo) {
        //(0/91): number starts with (0/91)
        //[7-9]: starting of the number may contain a digit between 0 to 9
        //[0-9]: then contains digits 0 to 9
        Pattern ptrn = Pattern.compile(
                "^[0-9]{10}$"

        );
        //the matcher() method creates a matcher that will match the given input against this pattern
        Matcher match = ptrn.matcher(mobileNo);
        //returns a boolean value
        return (match.find() && match.group().equals(mobileNo));
    }

    public static boolean isValidEmail(String email) {
        //(0/91): number starts with (0/91)
        //[7-9]: starting of the number may contain a digit between 0 to 9
        //[0-9]: then contains digits 0 to 9
        Pattern ptrn = Pattern.compile(
                "^(.+)@(\\S+)$"

        );
        //the matcher() method creates a matcher that will match the given input against this pattern
        Matcher match = ptrn.matcher(email);
        //returns a boolean value
        return (match.find() && match.group().equals(email));
    }

}
