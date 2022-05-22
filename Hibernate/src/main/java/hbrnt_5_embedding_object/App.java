package hbrnt_5_embedding_object;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();

        //Prepare the object
        Certificate certificate = new Certificate();
        Student student = new Student();

        certificate.setCourseName("Android");
        certificate.setDuration("3 Months");

        student.setName("Anand");
        student.setSem("6");
        student.setCerti(certificate);

        //Now save the object to the table
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();

        System.out.println("Table Created...");
    }
}

/*
OUTPUT

Hibernate:

    create table hibernate_embedding (
       id integer not null,
        course_name varchar(255),
        duration varchar(255),
        name varchar(255),
        sem varchar(255),
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
        hibernate_embedding
        (course_name, duration, name, sem, id)
    values
        (?, ?, ?, ?, ?)


Table Created...

 */