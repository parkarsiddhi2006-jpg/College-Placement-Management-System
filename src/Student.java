public class Student {

    String name;
    String email;
    String branch;
    double cgpa;
    String skills;

    public Student(String name, String email, String branch, double cgpa, String skills) {
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.cgpa = cgpa;
        this.skills = skills;
    }

    public void displayDetails() {
        System.out.println("Name   : " + name);
        System.out.println("Email  : " + email);
        System.out.println("Branch : " + branch);
        System.out.println("CGPA   : " + cgpa);
        System.out.println("Skills : " + skills);
    }
}