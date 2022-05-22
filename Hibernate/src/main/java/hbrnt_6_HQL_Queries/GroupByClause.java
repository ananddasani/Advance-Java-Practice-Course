package hbrnt_6_HQL_Queries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GroupByClause {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "update HQLInsert set name=: newName where id =:emp_id";

        Query query = session.createQuery(hql);
        session.beginTransaction();

        query.setParameter("newName", "Anand Dasani");
        query.setParameter("emp_id", 4);

        int rowAffected = query.executeUpdate();
        session.getTransaction().commit();

        if (rowAffected >= 1)
            System.out.println("\n\nUpdated...");
    }
}
