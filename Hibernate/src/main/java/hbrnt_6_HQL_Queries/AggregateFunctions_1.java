package hbrnt_6_HQL_Queries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AggregateFunctions_1 {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hqlWithSomeProp = "select count(e), avg(e.salary), sum(e.salary) from HQLInsert as e";

        session.beginTransaction();
        Query query = session.createQuery(hqlWithSomeProp);
        List<Object[]> list = query.list();

        session.getTransaction().commit();

        for (Object[] objects : list)
            System.out.println("\ncount of employee :: " + objects[0] + "\nsum of salary :: " + objects[2] + "\naverage of salary :: " + objects[1]);
    }
}

/*
i am having a table as follow

mysql> select * from hql_insert;
+--------+-------+--------+
| emp_id | name  | salary |
+--------+-------+--------+
|      1 | rahul |  50000 |
|      2 | jia   |  80000 |
|      3 | jay   |  85000 |
|      4 | anand |  95000 |
+--------+-------+--------+

Hibernate:
    select
        count(hqlinsert0_.emp_id) as col_0_0_,
        avg(hqlinsert0_.salary) as col_1_0_,
        sum(hqlinsert0_.salary) as col_2_0_
    from
        hql_insert hqlinsert0_

count of employee :: 4
sum of salary :: 310000
average of salary :: 77500.0

 */