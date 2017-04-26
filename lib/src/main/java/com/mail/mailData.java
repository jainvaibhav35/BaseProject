package com.mail;

public class mailData {

    private String subject;
    private String message;
    private String mailFrom;


    public mailData() {

    }

    public mailData(String subject, String message, String mailTo) {
        super();
        this.subject = subject;
        this.message = message;
        this.mailFrom = mailTo;
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

    public String getMailTo() {
        return mailFrom;
    }

    public void setMailTo(String mailTo) {
        this.mailFrom = mailTo;
    }


}
