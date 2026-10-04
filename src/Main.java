import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" COLLEGE PLACEMENT MANAGEMENT SYSTEM ");
            System.out.println("=================================");

            System.out.println("1. Student Login");
            System.out.println("2. Student Register");
            System.out.println("3. View Registered Students");
            System.out.println("4. Admin Login");
            System.out.println("5. Exit");

            System.out.print("\nChoose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n----- Student Login -----");

                    System.out.print("Enter Email: ");
                    String loginEmail = sc.nextLine();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.email.equalsIgnoreCase(loginEmail)) {
                            System.out.println("\nLogin Successful!");
                            System.out.println("Welcome, " + s.name + "!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("\nStudent not found.");
                    }
                    break;

                case 2:
                    System.out.println("\n----- Student Registration -----");

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Branch: ");
                    String branch = sc.nextLine();

                    double cgpa;
                    while (true) {
                        System.out.print("Enter CGPA (0-10): ");

                        if (sc.hasNextDouble()) {
                            cgpa = sc.nextDouble();

                            if (cgpa >= 0 && cgpa <= 10) {
                                sc.nextLine();
                                break;
                            } else {
                                System.out.println("CGPA must be between 0 and 10.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            sc.next();
                        }
                    }

                    System.out.print("Enter Skills: ");
                    String skills = sc.nextLine();

                    Student student = new Student(name, email, branch, cgpa, skills);
                    students.add(student);

                    System.out.println("\nRegistration Successful!");
                    student.displayDetails();
                    break;

                case 3:
                    System.out.println("\n----- Registered Students -----");

                    if (students.isEmpty()) {
                        System.out.println("No students registered yet.");
                    } else {
                        int count = 1;

                        for (Student s : students) {
                            System.out.println("\nStudent " + count++);
                            System.out.println("----------------------");
                            s.displayDetails();
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n----- Admin Login -----");
                    System.out.println("Admin module will be connected with MySQL later.");
                    break;

                case 5:
                    System.out.println("\nThank you for using College Placement Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid option. Please choose between 1 and 5.");
            }
        }
    }
}