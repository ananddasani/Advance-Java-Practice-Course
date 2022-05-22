package hbrnt_6_HQL_Queries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FromClause {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "FROM StudentManagement";

        session.beginTransaction();
        Query query = session.createQuery(hql);
        List list = query.list();
        session.beginTransaction().commit();

        for (Object studs : list)
            System.out.println(studs);
    }
}

/*
THIS IS THE TABLE I HAVE

mysql> select * from student_management;
+----+-----------+------------+------+-------+-----------+
| Id | FirstName | LastName   | Sem  | Marks | City      |
+----+-----------+------------+------+-------+-----------+
|  1 | Jay       | Dabhi      |    7 |    60 | Mumbai    |
|  2 | Deep      | Singh      |    7 |    60 | Goa       |
|  3 | Mihir     | Samani     |    5 |    85 | Pune      |
|  4 | Sia       | Joshi      |    7 |    50 | Mumbai    |
|  5 | Hetavi    | Dasani     |    7 |    90 | Porbandar |
|  7 | Ria       | Joshi      |    8 |    60 | Jaipur    |
|  8 | Anand     | Dasani     |    6 |    90 | Porbandar |
|  9 | Deep      | Brahmbhatt |    6 |    80 | Ahmedabad |
+----+-----------+------------+------+-------+-----------+

OUTPUT

Hibernate:
    select
        studentman0_.Id as id1_4_,
        studentman0_.City as city2_4_,
        studentman0_.FirstName as firstnam3_4_,
        studentman0_.LastName as lastname4_4_,
        studentman0_.Marks as marks5_4_,
        studentman0_.Sem as sem6_4_
    from
        student_management studentman0_
StudentManagement{id=1, firstName='Jay', lastName='Dabhi', sem=7, marks=60, city='Mumbai'}
StudentManagement{id=2, firstName='Deep', lastName='Singh', sem=7, marks=60, city='Goa'}
StudentManagement{id=3, firstName='Mihir', lastName='Samani', sem=5, marks=85, city='Pune'}
StudentManagement{id=4, firstName='Sia', lastName='Joshi', sem=7, marks=50, city='Mumbai'}
StudentManagement{id=5, firstName='Hetavi', lastName='Dasani', sem=7, marks=90, city='Porbandar'}
StudentManagement{id=7, firstName='Ria', lastName='Joshi', sem=8, marks=60, city='Jaipur'}
StudentManagement{id=8, firstName='Anand', lastName='Dasani', sem=6, marks=90, city='Porbandar'}
StudentManagement{id=9, firstName='Deep', lastName='Brahmbhatt', sem=6, marks=80, city='Ahmedabad'}

 */