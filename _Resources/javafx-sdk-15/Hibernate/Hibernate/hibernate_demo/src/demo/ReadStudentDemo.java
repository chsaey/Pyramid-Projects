package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        //create session factory this is for hibernate
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory) {
            //create a session this is for hibernate
            Session session = factory.getCurrentSession();

            //create a new student object
            System.out.println("\nCreating new student object...");
            Student tempStudent = new Student("Lindsay", "Ingram", "lindsay@code.com");

            //start a transaction
            session.beginTransaction();
            System.out.println("Beginning transaction...");

            //save the student object
            System.out.println("Saving the new student...");
            System.out.println("The saved student: " + tempStudent);
            session.save(tempStudent);

            //commit the transaction
            session.getTransaction().commit();

            //***********************************************************************************
            //***Code for Reading the object***
            //find out the student's id: primary key
            System.out.println("\n******************************\n");
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            //Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve student based on the id: pr imary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get Completed: " + myStudent);

            //Retrieve student object with id: 1 in database
            System.out.println("\n**********************************");
            int studentId = 1;
            System.out.println("Getting student with id: " + studentId);
            Student crazyStudent = session.get(Student.class, studentId);
            System.out.println(crazyStudent);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
