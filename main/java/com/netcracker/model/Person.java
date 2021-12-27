package com.netcracker.model;

import javax.validation.constraints.*;

public class Person {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String firstName;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String lastName;

    @Positive(message = "Age should be greater than 0")
    private int age;

    @Positive(message = "Salary should be greater than 0")
    private int salary;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    private String workPlace;

    public Person(){

    }
    public Person(String firstName,String lastName, int age, int salary, String email, String workPlace){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.email = email;
        this.workPlace = workPlace;
    }

    public void stringToPerson(String str){
        String[] vars = str.split(" ");
        this.firstName = vars[0];
        this.lastName = vars[1];
        this.age = Integer.parseInt(vars[2]);
        this.salary = Integer.parseInt(vars[3]);
        this.email = vars[4];
        this.workPlace = vars[5];
    }

    @Override
    public String toString() {
        return firstName+" "
                +lastName+" "
                +age+" "
                +salary+" "
                +email + " "
                + workPlace;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getWorkPlace() {
        return workPlace;
    }




    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }





}
