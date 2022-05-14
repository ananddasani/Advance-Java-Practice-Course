package Practical_Questions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class P5_MyConnector {

    static Connection connection;

    /**
     * Method will create connection with our database
     *
     * @return the created connection
     */
    public static Connection makeConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(P5_Constants.DB_URL, P5_Constants.USER, P5_Constants.PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
