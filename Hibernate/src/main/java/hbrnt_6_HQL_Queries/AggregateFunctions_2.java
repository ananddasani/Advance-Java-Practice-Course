package hbrnt_6_HQL_Queries;

import hbrnt_6_HQL_Queries.model.AggregateResultModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AggregateFunctions_2 {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hqlWithSomeProp = "select new hbrnt_6_HQL_Queries.model.AggregateResultModel (" +
                "count(e), avg(e.salary), sum(e.salary))" +
                "from HQLInsert as e";

        session.beginTransaction();
        Query<AggregateResultModel> query = session.createQuery(hqlWithSomeProp, AggregateResultModel.class);
        AggregateResultModel aggregateResultModel = query.uniqueResult();

        session.getTransaction().commit();

        //instead of printing i have collected the result in the separate model class (hbrnt_6_HQL_Queries.model.AggregateResultModel)
//        for (Object[] objects : list)
//            System.out.println("\ncount of employee :: " + objects[0] + "\nsum of salary :: " + objects[2] + "\naverage of salary :: " + objects[1]);

        System.out.println("Count of employee :: " + aggregateResultModel.getEmpCount());
        System.out.println("Sum of salary :: " + aggregateResultModel.getSumSalary());
        System.out.println("Average of salary :: " + aggregateResultModel.getAvgSalary());

    }
}

/*
table i already have

mysql> select * from hql_insert;
+--------+-------+--------+
| emp_id | name  | salary |
+--------+-------+--------+
|      1 | rahul |  50000 |
|      2 | jia   |  80000 |
|      3 | jay   |  85000 |
|      4 | anand |  95000 |
+--------+-------+--------+

OUTPUT

Hibernate:
    select
        count(hqlinsert0_.emp_id) as col_0_0_,
        avg(hqlinsert0_.salary) as col_1_0_,
        sum(hqlinsert0_.salary) as col_2_0_
    from
        hql_insert hqlinsert0_

-----------------------------------
Count of employee :: 4
Sum of salary :: 310000
Average of salary :: 77500.0
-----------------------------------

 */
