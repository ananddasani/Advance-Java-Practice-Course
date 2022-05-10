package JDBC_Basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class JDBC_4_Inserting_Image_in_DB {

    public static String USER = "root";
    public static String PASS = "root";
    public static String URL = "jdbc:mysql://localhost:3306/anand";

    //Create Table which can hold image (blob type) (blob :: binary large object)
    public static String CREATE_TABLE = "create table image_table(Id int primary key auto_increment, Pic longblob)";
    public static String INSERT_IMAGE = "insert into image_table(Pic) values(?)";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PASS);

        boolean isTableCreated = createTable(connection);

        if (!isTableCreated) {
            System.out.println("Enable to Create Table");
            System.exit(0);
        }

        //now table is created insert the image into table using dynamic query
        System.out.println("\nInserting the image...");

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_IMAGE);

        //setting the image
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\anand\\Pictures\\WallPaper\\kali.png");

            //Image is of Binary type
            preparedStatement.setBinaryStream(1, fileInputStream, fileInputStream.available());
            preparedStatement.executeUpdate();

            System.out.println("Image Inserted Successfully");

        } catch (FileNotFoundException e) {
            System.out.println("Image not found in folder you are looking at...");
        } catch (IOException e) {
            System.out.println("Not Available");
        }
    }

    /**
     * Method to Create the Table
     *
     * @param connection is the connection object created
     * @return true if table is created else false
     */
    public static boolean createTable(Connection connection) {

        Statement statement = null; // For Creating Table
        try {
            statement = connection.createStatement();
            statement.executeUpdate(CREATE_TABLE);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

/*
OUTPUT

Inserting the image...
Image Inserted Successfully
 */
