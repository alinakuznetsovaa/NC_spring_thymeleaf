package com.netcracker.parser;

import com.netcracker.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class PersonParser {

    private List<Person> peers= new ArrayList<>();
    String separator = File.separator;
    private String path = "src"+separator+"main"+separator+"resources" + separator + "uploaded" + separator;

    public PersonParser() throws IOException {
        addPeersToListFromFile("people.txt");


    }

    public Person searchPerson(String firstName, String lastName){
        for(Person person: peers){
            if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                return person;
        }
        return null;
    }

    private void uploadFile(MultipartFile file) throws IOException {
        File fileFrom = new File(path + file.getOriginalFilename());
        fileFrom.createNewFile();
        FileOutputStream fout = new FileOutputStream(fileFrom);
        fout.write(file.getBytes());
        fout.flush();
        fout.close();
    }

    private void addPeersToListFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            Person newPerson = new Person();
            newPerson.stringToPerson(line);
            peers.add(newPerson);
        }

    }

    public void addPeersFromFile(MultipartFile file) throws IOException {
        uploadFile(file);
        addPeersToListFromFile(path + file.getOriginalFilename());
        fileRewrite("people.txt");
    }

    private void fileRewrite(String filePath) throws IOException {

        File newFile = new File(filePath);
        FileWriter fw = new FileWriter(newFile, true);
        for(Person person : peers){
            fw.write(person.toString() + "\n");
        }
        fw.close();
    }

    public List<Person> getPeers() {
       return peers;
    }
}
