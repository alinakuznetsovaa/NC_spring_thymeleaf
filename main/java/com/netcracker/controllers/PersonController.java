package com.netcracker.controllers;

import com.netcracker.model.Information;
import com.netcracker.model.Person;
import com.netcracker.parser.PersonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class PersonController {
    private PersonParser personParser;



    @GetMapping("/person")
    public String personForm(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("/person")
    public String personSubmit(@ModelAttribute("person") @Valid Person person,
                               Errors errors, Model model) throws IOException {
        if (errors.hasErrors())
            return "person";
//        personParser.addPerson(person);
//        model.addAttribute("peers",personParser.getPeers());
        FileWriter file = new FileWriter("people.txt", true);
        file.write(person.getFirstName() + " " + person.getLastName() + " " + person.getAge() + " "  + person.getSalary() + " " + person.getEmail() + " " + person.getWorkPlace() + '\n');
        file.flush();
        file.close();
        person.setFirstName(null);
        person.setLastName(null);
        person.setAge(0);
        person.setEmail(null);
        person.setSalary(0);
        person.setWorkPlace(null);


        return "person";
    }

    @GetMapping("/search")
    public String searchPersonForm(Model model){
        model.addAttribute("person", new Person());
        return "search";
    }

    @PostMapping("/search")
    public String searchPerson(@ModelAttribute("information") Information information,
                               @ModelAttribute("person") @Valid Person person,
                               Errors errors,
                               Model model,
                               HttpServletRequest request ) throws IOException  {


        if (errors.hasFieldErrors("firstName") || errors.hasFieldErrors("lastName"))
            return "search";

        information.setMessage(request);
        personParser = new PersonParser();
        Person person1 = personParser.searchPerson(person.getFirstName(), person.getLastName());

        if (person1 == null)
            return "person_not_found";

        model.addAttribute("person", person1);
        person.setFirstName(null);
        person.setLastName(null);
        return "person_is_found";
    }


}

