package hbrnt_6_HQL_Queries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SelectClause {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hqlWithSomeProp = "select id, firstName, sem from StudentManagement";

        session.beginTransaction();
        Query query = session.createQuery(hqlWithSomeProp);
        List<Object[]> list = query.list();
        session.getTransaction().commit();

        for (Object[] objects : list)
            System.out.println("\nid :: " + objects[0] + "\nfirst name :: " + objects[1] + "\nsem :: " + objects[2]);
    }
}

/*
OUTPUT

Hibernate:
    select
        studentman0_.Id as col_0_0_,
        studentman0_.FirstName as col_1_0_,
        studentman0_.Sem as col_2_0_
    from
        student_management studentman0_

id :: 1
first name :: Jay
sem :: 7

id :: 2
first name :: Deep
sem :: 7

id :: 3
first name :: Mihir
sem :: 5

id :: 4
first name :: Sia
sem :: 7

id :: 5
first name :: Hetavi
sem :: 7

id :: 7
first name :: Ria
sem :: 8

id :: 8
first name :: Anand
sem :: 6

id :: 9
first name :: Deep
sem :: 6

 */