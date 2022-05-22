package hbrnt_3_insert_image;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;


public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //create the object and set the image
        Image_Hibernate image_hibernate = new Image_Hibernate();

        // Reading image
        try {
            FileInputStream inputStream = new FileInputStream("src/main/mySnap.jpg");

            byte[] image = new byte[inputStream.available()];
            inputStream.read(image);

            image_hibernate.setImage(image);

            //save to table
            session.beginTransaction();
            session.persist(image_hibernate);
            session.getTransaction().commit();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
