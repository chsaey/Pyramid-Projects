package com.company;

import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();

    public static void main(String[] args) {
        // write your code here
        boolean play = true;
        System.out.println("Welcome to the Employee terminal");
        String input = "";

        while (play) {
            prompt();
            input = scan.nextLine();
            scan.reset();
            switch (input.toLowerCase()) {
                case "1":
                    addEmployee();
                    break;
                case "2":
                    getEmployee();
                    break;
                case "3":
                    getEmployeesOfCompany();
                    break;
                case "4":
                    deleteEmployee();
                    break;
                case "exit":
                    factory.close();
                    play =false;
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }

    //save objects
    public static boolean addEmployee() {

        try {
            Session session = factory.openSession();
            System.out.println("Enter first name: ");
            String firstName = scan.nextLine();
            System.out.println("Enter last name: ");
            String lastName = scan.nextLine();
            System.out.println("Enter company name: ");
            String companyName = scan.nextLine();
            Employee employee = new Employee(firstName, lastName, companyName);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("error");
            return false;
        }
    }

    //retrieve employee with primary key
    public static boolean getEmployee() {
        try {

            System.out.println("Enter employees ID to retrieve their information: ");
            String ID = scan.nextLine();
            Session session = factory.openSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, Integer.parseInt(ID));
            System.out.println(employee.toString());
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            System.out.println("Employee doesn't exist or something else went wrong");
            return false;
        }
        return false;
    }

    //query db to find employees of a company
    public static boolean getEmployeesOfCompany() {
        try {
            System.out.println("Please enter the company's name: ");
            String companyName = scan.nextLine();
            Session session = factory.openSession();
            session.beginTransaction();
            List<Employee> theEmployees = session.createQuery("from Employee where company='" + companyName + "'").getResultList();
            displayResult(theEmployees);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Company is not found or something else went wrong");
            return false;
        }
    }

    //delete employee with primary key
    public static boolean deleteEmployee() {
        try {
            System.out.println("Enter Employees ID to delete: ");
            String ID = scan.nextLine();
            Session session = factory.openSession();
            session.beginTransaction();
            session.createQuery("delete from Employee where id=" + Integer.parseInt(ID)).executeUpdate();
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("ID not found or something else went wrong");
            return false;
        }
    }

    public static void prompt() {
        System.out.println("What would you like to do?");
        System.out.println("1). Add employee");
        System.out.println("2). Get employee");
        System.out.println("3). Get Employees by company");
        System.out.println("4). Delete Employee by ID");
    }

    public static void displayResult(List<Employee> employees) {
        for (Employee e : employees
        ) {
            System.out.println(e);
        }
    }
}
