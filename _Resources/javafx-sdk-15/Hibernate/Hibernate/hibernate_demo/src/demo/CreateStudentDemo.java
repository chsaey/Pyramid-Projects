package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        //create session factoryh
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try{
            //create a session
            Session session = factory.getCurrentSession();

            //create 6 student objects
            System.out.println("Creating 4 student objects...");
            Student tempStudent = new Student("Ellie", "Ingram", "ellie@code.com");
            Student tempStudent1 = new Student("Laila", "Lindsay", "laila@code.com");
            Student tempStudent2 = new Student("Lindsay", "Ingram", "lindsay@code.com");
            Student tempStudent3 = new Student("Jim", "Jack", "jim@code.com");


            //start a transaction
            session.beginTransaction();
            System.out.println("Beginning transaction...");

            //save the student object
            session.save(tempStudent);
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            System.out.println("Saving the new students...");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
