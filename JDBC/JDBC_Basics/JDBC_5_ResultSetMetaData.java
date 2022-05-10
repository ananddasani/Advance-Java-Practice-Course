package JDBC_Basics;

import java.sql.*;

public class JDBC_5_ResultSetMetaData {

    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/anand";


    public static void main(String[] args) {

        String query = "select * from students_jdbc";

        try {
            //load the driver in the memory dynamically
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Crete the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            //Create the statement
            Statement statement = connection.createStatement();

            //Execute Query
            ResultSet resultSet = statement.executeQuery(query);

            //Using ResultSetMetaData extracting raw information of the table
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            //------------------ Common Methods --------------------------
            System.out.println("Table Name :: " + resultSetMetaData.getTableName(1));
            System.out.println("Column Count :: " + resultSetMetaData.getColumnCount());
            System.out.println("Column Name :: " + resultSetMetaData.getColumnName(1));
            System.out.println("Column Type (1) :: " + resultSetMetaData.getColumnType(1));


            //------------ Other Methods -----------------------------
            System.out.println("\nColumn Type Name (2) :: " + resultSetMetaData.getColumnTypeName(2));
            System.out.println("Column Label (2) :: " + resultSetMetaData.getColumnLabel(2));
            System.out.println("Schema Name :: " + resultSetMetaData.getSchemaName(2));
            System.out.println("Precision :: " + resultSetMetaData.getPrecision(1));

            System.out.println();
            System.out.println();

            //Extract the result and print it
            while (resultSet.next()) {
                //Extract the data
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                int sem = resultSet.getInt("Sem");
                String city = resultSet.getString("City");

                //print the collected the data on the console
                System.out.println(id + " " + name + " " + sem + " " + city);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
Table Name :: students_jdbc
Column Count :: 4
Column Name :: Id
Column Type (1) :: 4

Column Type Name (2) :: VARCHAR
Column Label (2) :: Name
Schema Name ::
Precision :: 10


1 Anand 5 Porbandar
2 Deep 7 Pune
3 Jay 4 Chennai
4 Meet 8 Mumbai
5 Manoj 6 Goa
6 Ria 7 PUne

 */