package hbrnt_4_get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // get table by primary key (Enrollment_no)
        ModelClass modelClass = (ModelClass) session.get(ModelClass.class, 102);

        System.out.println();
        System.out.println(modelClass);
        System.out.println("Mobile :: " + modelClass.getMobile());
    }
}

/*
THIS IS THE TABLE I HAVE
+---------------+-------+----------+------------+
| Enrollment_no | Sname | Semester | Mobile_no  |
+---------------+-------+----------+------------+
|             0 | NULL  |     NULL | NULL       |
|           102 | Ria   |        6 | 9428428205 |
+---------------+-------+----------+------------+


OUTPUT
Hibernate:
    select
        modelclass0_.Enrollment_no as enrollme1_0_0_,
        modelclass0_.Mobile_no as mobile_n2_0_0_,
        modelclass0_.Sname as sname3_0_0_,
        modelclass0_.Semester as semester4_0_0_
    from
        servlet_jdbc modelclass0_
    where
        modelclass0_.Enrollment_no=?


StudentManagement{enrolment=102, name='Ria', sem=6, mobile='9428428205'}

 */