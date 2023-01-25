package com.avengers.studentManagement;

public class Student {
    private String name ;
    private int age ;
    private int adminNumber ;
    private String country ;

    public Student(String name, int age, int adminNumber, String country) {
        this.name = name;
        this.age = age;
        this.adminNumber = adminNumber;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(int adminNumber) {
        this.adminNumber = adminNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
