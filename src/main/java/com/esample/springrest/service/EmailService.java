package com.esample.springrest.service;

import com.esample.springrest.model.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);

}
