package hbrnt_1_persist;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Students students = new Students();

        students.setfName("Ria");
        students.setlName("Somani");
        students.setCity("Porbandar");
        students.setMarks(85);

        session.persist(students);
        transaction.commit();

        System.out.println("Data inserted successfully...");
    }
}
