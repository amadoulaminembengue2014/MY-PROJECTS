package com.vlm.cityhall.mailcontroller;

public class EmailSender {

    private String to;
    private String subject;
    private String message;
   // private String attachement;


    public EmailSender() {
    }

    public EmailSender(String to, String subject, String message)
                       //String attachement)
                       {
        this.to = to;
        this.subject = subject;
        this.message = message;
//        this.attachement=attachement;
    }

    /*public String getAttachement() {
        return attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }
*/
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
