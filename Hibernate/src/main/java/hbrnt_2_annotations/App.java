/*
Demo of various commonly used Annotations in hibernate
 */

package hbrnt_2_annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("org/example/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //prepare data to be inserted into the table
        Annotations annotations = new Annotations();

        //Don't Set address id it is auto incremented
        //annotations.setAddressId(1);
        annotations.setCity("Porbandar");
        annotations.setAddedDate(new Date());
        annotations.setX(123.456);

        //save the object to the table
        session.beginTransaction();
        session.persist(annotations);
        session.getTransaction().commit();
    }
}

/*
OUTPUT

Hibernate:

    create table hibernate_annotations (
       id integer not null,
        date_added date,
        city varchar(255),
        primary key (id)
    ) engine=InnoDB

Hibernate:
    select
        next_val as id_val
    from
        hibernate_sequence for update

Hibernate:
    update
        hibernate_sequence
    set
        next_val= ?
    where
        next_val=?
Hibernate:
    insert
    into
        hibernate_annotations
        (date_added, city, id)
    values
        (?, ?, ?)
 */