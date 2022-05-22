package hbrnt_6_HQL_Queries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteClause {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "delete from HQLInsert where id =:emp_id";

        Query query = session.createQuery(hql);
        session.beginTransaction();

        query.setParameter("emp_id", 4);

        int rowAffected = query.executeUpdate();
        session.getTransaction().commit();

        if (rowAffected >= 1)
            System.out.println("\n\nDeleted...");
    }
}

/*
i am having hql_insert table as follow

mysql> select * from hql_insert;
+--------+--------------+--------+
| emp_id | name         | salary |
+--------+--------------+--------+
|      1 | rahul        |  50000 |
|      2 | jia          |  80000 |
|      3 | jay          |  85000 |
|      4 | Anand Dasani |  95000 |
+--------+--------------+--------+

Hibernate:
    delete
    from
        hql_insert
    where
        emp_id=?

-------------
Deleted...
--------------

mysql> select * from hql_insert;
+--------+-------+--------+
| emp_id | name  | salary |
+--------+-------+--------+
|      1 | rahul |  50000 |
|      2 | jia   |  80000 |
|      3 | jay   |  85000 |
+--------+-------+--------+
 */