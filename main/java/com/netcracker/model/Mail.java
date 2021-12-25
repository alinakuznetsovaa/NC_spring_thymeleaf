package com.netcracker.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Mail {
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String recipient;

    private String subject;
    private String message;


    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
