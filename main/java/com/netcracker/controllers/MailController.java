package com.netcracker.controllers;

import com.netcracker.model.Mail;
import com.netcracker.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class MailController {
    private EmailService emailService;


    public MailController(EmailService emailService){
        this.emailService = emailService;
    }

    @GetMapping("/send")
    public String getMail(Model model) {
        model.addAttribute("mail", new Mail());
        return "mail";
    }

    @PostMapping("/send")
    public String sendMail(@ModelAttribute("mail") @Valid Mail mail,
                           Errors errors) throws IOException {

        if (errors.hasErrors())
            return "mail";


        emailService.sendSimpleMessage(mail.getRecipient(),mail.getSubject(),mail.getMessage());
        return "message_send";
    }
}
