package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class QueryStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try{
            //create a session
            Session session = factory.getCurrentSession();
            //start a transaction
            session.beginTransaction();

            //Query Student: All Students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //Display Students
            System.out.println("\nDisplaying all the Students...");
            displayStudents(theStudents);

            System.out.println("\n**************");

            //Displaying the student at ID 2 or primary key 2
            System.out.println("\nStudent Id: " +
                    theStudents.get(1).getId() + " First Name: " + theStudents.get(1).getFirstName());

            System.out.println("********************");

            //Query all the Students with the last name = 'Bear'
            theStudents = session.createQuery("from Student where lastName='Bear'").getResultList();
            //Display results
            System.out.println("\nDisplaying all the Students with last name of Bear.");
            displayStudents(theStudents);

            System.out.println("****************");

            //Delete all the students at once
            List<Student> deleteAllStudents = session.createQuery("from Student").getResultList();
            for(Student student: deleteAllStudents) {
                session.delete(student);
            }

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("\nDone!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
