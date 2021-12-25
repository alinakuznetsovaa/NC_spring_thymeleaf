package com.netcracker.parser;

import com.netcracker.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonParser {
    private List<Person> peers;
    String separator = File.separator;
    private String path = "main"+separator+"src"+separator;

    public PersonParser() throws IOException {
        peers = new ArrayList<>();
        File file = new File("people.txt");

        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Person newPerson = new Person();
            newPerson.stringToPerson(line);
            peers.add(newPerson);
        }

    }

//    public void addPerson(Person person) throws IOException {
//        peers.add(person);
//
//        File file = new File( "people.txt");
//        FileWriter fw = new FileWriter(file, true);
//
//        fw.write(person.toString() + "\n");
//
//        fw.close();
//    }

    public Person searchPerson(String firstName, String lastName){
        for(Person person: peers){
            if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                return person;
        }
        return null;
    }

    public List<Person> getPeers() {
       return peers;
    }
}
