package JDBC_Basics;

import java.sql.*;

public class JDBC_1_SELECT_Query {

    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/anand";

    public static String query = "select * from students_jdbc";

    public static void main(String[] args) {

        try {
            //connect database
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            //create Statement
            Statement statement = connection.createStatement();

            //execute Query
            ResultSet resultSet = statement.executeQuery(query);

            //show the output
            while (resultSet.next()) {

                //Table Data
                String name = resultSet.getString("name");
                int sem = resultSet.getInt("sem");
                String city = resultSet.getString("city");

                System.out.println(name + " : " + sem + " : " + city);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
