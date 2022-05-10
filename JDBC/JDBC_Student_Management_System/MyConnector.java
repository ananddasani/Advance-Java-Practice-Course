package JDBC_Student_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnector {

    static Connection connection;

    /**
     * Method will create connection with our database
     *
     * @return the created connection
     */
    public static Connection makeConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
