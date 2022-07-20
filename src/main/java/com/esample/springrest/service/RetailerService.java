package com.esample.springrest.service;


import com.esample.springrest.entities.RetailerUser;
import com.esample.springrest.model.RetailerInput;
import com.esample.springrest.repository.RetailerRepository;
import com.esample.springrest.response.RetailerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RetailerService {
    @Autowired
    RetailerRepository retailerRepository;


    public RetailerResponse retailerOnboard(RetailerInput retailerInput) {
        try {
            if (!isValidAadhaarNumber(retailerInput.getAadharNumber())) {
                return new RetailerResponse("Failure", "Aadhar Number not valid");
            }
            if (!isValidPanCardNo(retailerInput.getPanNumber())) {
                return new RetailerResponse("Failure", "Pan Number not valid");
            }
            if(!isValidGSTNo(retailerInput.getGstNumber())){
                return new RetailerResponse("Failure", "Gst Number  not valid");
            }
            if(!isValidIFSCode(retailerInput.getIfscCode())){
                return new RetailerResponse("Failure", "Ifsc Code not valid");
            }
            if(!isValidAccountNumber(retailerInput.getAccountNumber())){
                return new RetailerResponse("Failure", " Account Number  not valid");
            }
            if(!isValidConfirmAccountNumber(retailerInput.getConfirmAccountNumber())){
                return new RetailerResponse("Failure", "Ifsc Code not valid");

            }

            RetailerUser retailerUser = new RetailerUser();
            retailerUser.setPanNumber(retailerInput.getPanNumber());

            retailerUser.setAadharNumber(retailerInput.getAadharNumber());
            retailerUser.setGst(retailerInput.getGstNumber());
            retailerUser.setIfscCode(retailerInput.getIfscCode());
            retailerUser.setAccountNumber((retailerInput.getAccountNumber()));
            retailerUser.setConfirmAccountNumber(retailerInput.getConfirmAccountNumber());
            RetailerUser userReturned = retailerRepository.save(retailerUser);
            return new RetailerResponse("SUCCESS", "Successfully signed up.");
        } catch (Exception ex) {
            return new RetailerResponse("FAILURE", ex.getMessage());
        }
    }
        public static boolean isValidPanCardNo(String panCardNo)
        {

            // Regex to check valid PAN Card number.
            String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

            // Compile the ReGex
            Pattern p = Pattern.compile(regex);

            // If the PAN Card number
            // is empty return false
            if (panCardNo == null)
            {
                return false;
            }

            // Pattern class contains matcher() method
            // to find matching between given
            // PAN Card number using regular expression.
            Matcher m = p.matcher(panCardNo);

            // Return if the PAN Card number
            // matched the ReGex
            return m.matches();
        }
        public static boolean isValidAadhaarNumber(String aadhar)
        {
            // Regex to check valid Aadhaar number.
            String regex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";

            // Compile the ReGex
            Pattern p = Pattern.compile(regex);

            // If the string is empty
            // return false
            if (aadhar == null) {
                return false;
            }

            // Pattern class contains matcher() method
            // to find matching between given string
            // and regular expression.
            Matcher m = p.matcher(aadhar);

            // Return if the string
            // matched the ReGex
            return m.matches();
        }
    public static boolean isValidGSTNo(String gstNo)
    {
        // Regex to check valid
        // GST (Goods and Services Tax) number
        String regex = "^[0-9]{2}[A-Z]{5}[0-9]{4}"
                + "[A-Z]{1}[1-9A-Z]{1}"
                + "Z[0-9A-Z]{1}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (gstNo == null)
        {
            return false;
        }

        // Pattern class contains matcher()
        // method to find the matching
        // between the given string
        // and the regular expression.
        Matcher m = p.matcher(gstNo);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }
    public static boolean isValidIFSCode(String IFSCode)
    {
        // Regex to check valid IFSC Code.
        String regex = "^[A-Z]{4}0[A-Z0-9]{6}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (IFSCode == null) {
            return false;
        }

        // Pattern class contains matcher()
        // method to find matching between
        // the given string and
        // the regular expression.
        Matcher m = p.matcher(IFSCode);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }
    public static boolean isValidAccountNumber(String AccountNumber)
    {
        String regex = "[0-9]{9,18}";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (AccountNumber == null) {
            return false;
        }

        // Pattern class contains matcher()
        // method to find matching between
        // the given string and
        // the regular expression.
        Matcher m = p.matcher(AccountNumber);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }
    public static boolean isValidConfirmAccountNumber(String ConfirmAccountNumber)
    {
        String regex = "[0-9]{9,18}";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (ConfirmAccountNumber == null) {
            return false;
        }

        // Pattern class contains matcher()
        // method to find matching between
        // the given string and
        // the regular expression.
        Matcher m = p.matcher(ConfirmAccountNumber);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }
}

