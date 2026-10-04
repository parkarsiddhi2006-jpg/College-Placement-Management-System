package com.cpms.cpmsbackend.model;

public class Student {

    private String name;
    private String email;
    private String branch;
    private double cgpa;
    private String skills;

    public Student() {
    }

    public Student(String name, String email, String branch, double cgpa, String skills) {
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.cgpa = cgpa;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}