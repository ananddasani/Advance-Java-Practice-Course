package hbrnt_6_HQL_Queries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class InsertClause {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "insert into HQLInsert (id, name, salary)" +
                "select id, name, salary from HQLInsertBackup ";

        Query query = session.createQuery(hql);
        session.beginTransaction();
        int rowAffected = query.executeUpdate();

        if (rowAffected >= 1)
            System.out.println("\n\nInserted...");

        session.getTransaction().commit();
    }
}

/*
NOTE
in hql only INSERT INTO ... SELECT  is supported
not INSERT INTO VALUES :(

so you will require source table and target table (ofcourse with their model classes {HQLInsert, HQLInsertBackup})
-----------------------------------------------------------------------------
so i am having two tables

mysql> create table hql_insert (emp_id int, name varchar(20), salary int, primary key(emp_id));
mysql> create table hql_insert_backup (emp_id int, name varchar(20), salary int, primary key(emp_id));

mysql> select * from hql_insert_backup;
+--------+-------+--------+
| emp_id | name  | salary |
+--------+-------+--------+
|      1 | rahul |  50000 |
|      2 | jia   |  80000 |
|      3 | jay   |  85000 |
|      4 | anand |  95000 |
+--------+-------+--------+

-------------
Hibernate:
    insert
    into
        hql_insert
        ( emp_id, name, salary ) select
            hqlinsertb0_.emp_id as col_0_0_,
            hqlinsertb0_.name as col_1_0_,
            hqlinsertb0_.salary as col_2_0_
        from
            hql_insert_backup hqlinsertb0_

-------------
inserted...
-------------

-------------

mysql> select * from hql_insert;
+--------+-------+--------+
| emp_id | name  | salary |
+--------+-------+--------+
|      1 | rahul |  50000 |
|      2 | jia   |  80000 |
|      3 | jay   |  85000 |
|      4 | anand |  95000 |
+--------+-------+--------+

 */