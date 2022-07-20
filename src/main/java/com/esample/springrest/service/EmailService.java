package com.esample.springrest.service;

import com.esample.springrest.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;


public interface EmailService {
    String sendSimpleMail(EmailDetails details);

}
