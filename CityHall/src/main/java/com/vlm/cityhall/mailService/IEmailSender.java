package com.vlm.cityhall.mailService;

import javax.mail.MessagingException;

public interface IEmailSender {
    public void sendEmail(String to, String subject, String message
            //,String attachement
    ) throws MessagingException;
}

