package JDBC_Basics;

import java.sql.*;

public class JDBC_2_DML_Query {

    public static String USER = "root";
    public static String PASS = "root";
    public static String URL = "jdbc:mysql://localhost:3306/anand";

    public static String CREATE_TABLE = "create table students_jdbc(Id int primary key auto_increment, Name varchar(40), Sem int, City varchar(40)";

    public static String INSERT_QUERY = "INSERT INTO students_jdbc " +
            "(Id, Name, Sem, City) " +
            "values(6, 'Ria', 7, 'Jaipur') ";

    public static String UPDATE_QUERY1 = "UPDATE students_jdbc " +
            "SET Sem=7 " +
            "where Id=2";

    public static String UPDATE_QUERY2 = "UPDATE students_jdbc " +
            "SET Sem=3 " +
            "where Name='Om'";

    public static String DELETE_QUERY = "DELETE from students_jdbc " +
            "where id=6";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            //Create Statement
            Statement statement = connection.createStatement();

            // Execute the query
            int resultSet = statement.executeUpdate(DELETE_QUERY);

            if (resultSet != 0)
                System.out.println(resultSet + " rows affected");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
int resultSet = statement.executeUpdate(INSERT_QUERY);

Returns either
(1) the row count for SQL Data Manipulation Language (DML) statements or
(2) 0 for SQL statements that return nothing

---

executeUpdate(sql)
Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement or an SQL statement that returns nothing, such as an SQL DDL statement.
Note:This method cannot be called on a PreparedStatement or CallableStatement.
Params:
sql – an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE; or an SQL statement that returns nothing, such as a DDL statement.
 */