package hbrnt_6_HQL_Queries;

import hbrnt_6_HQL_Queries.model.StudentManagement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class WhereClause {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //create the query
        String hql = "FROM StudentManagement AS s WHERE s.id = ?1";
        Query query = session.createQuery(hql);

        //set dynamic value
        int dynamicId = 8;
        query.setParameter(1, dynamicId);

        //execute the query
        List list = query.list();

        //show the result
        for (Object studs : list)
            System.out.println(studs);

        //-----------------------------------------------------------------------------------

        String hqlWithNamedParameter = "FROM StudentManagement AS s WHERE s.city =: dynamicCity";
        Query query1 = session.createQuery(hqlWithNamedParameter);

        String dynamicCity = "porbandar";
        query1.setParameter("dynamicCity", dynamicCity);

        List list1 = query1.list();

        for (Object studs1 : list1)
            System.out.println(studs1);

        //-----------------------------------------------------------------------------------------

        String hqlWhereAnd = "FROM StudentManagement AS s WHERE s.city =: City and s.firstName =: Name ";
        Query query2 = session.createQuery(hqlWhereAnd);

        String city = "porbandar";
        query2.setParameter("City", city);

        String name = "Anand";
        query2.setParameter("Name", name);

        //as we will get the unique result (due to where)
        StudentManagement studentManagement = (StudentManagement) query2.uniqueResult();

        //show the required info
        System.out.println(studentManagement);

        System.out.println("\nMarks :: " + studentManagement.getMarks());
    }
}

/*
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
    where
        studentman0_.Id=?

---------------------------------------------------------------------------------------------------
StudentManagement{id=8, firstName='Anand', lastName='Dasani', sem=6, marks=90, city='Porbandar'}
---------------------------------------------------------------------------------------------------

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
    where
        studentman0_.City=?

---------------------------------------------------------------------------------------------------
StudentManagement{id=8, firstName='Anand', lastName='Dasani', sem=6, marks=90, city='Porbandar'}
StudentManagement{id=5, firstName='Hetavi', lastName='Dasani', sem=7, marks=90, city='Porbandar'}
StudentManagement{id=8, firstName='Anand', lastName='Dasani', sem=6, marks=90, city='Porbandar'}
---------------------------------------------------------------------------------------------------

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
    where
        studentman0_.City=?
        and studentman0_.FirstName=?

---------------------------------------------------------------------------------------------------
StudentManagement{id=8, firstName='Anand', lastName='Dasani', sem=6, marks=90, city='Porbandar'}

Marks :: 90
---------------------------------------------------------------------------------------------------

 */