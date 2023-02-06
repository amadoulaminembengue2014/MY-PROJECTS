package com.vlm.cityhall.mailService;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailSenderService implements IEmailSender{

    private final JavaMailSender javaMailSender;


    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void sendEmail(String to, String subject, String message
           // ,String attachement
    ) throws MessagingException {

//      SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("ndaoibrahima037@gmail.com");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(message);

       /* FileSystemResource fileSystemResource = new FileSystemResource(new File(attachement));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
*/
        this.javaMailSender.send(mimeMessage);



    }
}

