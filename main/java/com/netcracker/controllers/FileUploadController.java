package com.netcracker.controllers;

import com.netcracker.parser.PersonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {
    private PersonParser personParser;

    @Autowired
    public FileUploadController(PersonParser personParser) {
        this.personParser = personParser;
    }


    @GetMapping("/add_peers_from_file")
    public String uploadFileForm() {
        return "add_peers_from_file";
    }


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        personParser.addPeersFromFile(file);

        return "redirect:/person";
    }
}
