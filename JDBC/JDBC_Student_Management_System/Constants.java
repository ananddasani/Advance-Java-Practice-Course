package JDBC_Student_Management_System;

public class Constants {

    //Credentials
    public static String USER = "root";
    public static String PASSWORD = "root";
    public static String DB_URL = "jdbc:mysql://localhost:3306/anand";

    //Queries
    public static String SELECT_QUERY = "select * from student_management";

    public static String INSERT_QUERY = "insert into student_management" +
            "(FirstName, LastName, Sem, Marks, City) " +
            "values (?, ?, ?, ?, ?)";

    public static String DELETE_QUERY = "delete from student_management " +
            "where id=?";

    public static String UPDATE_ALL_QUERY = "update student_management " +
            "set FirstName=?, LastName=?, Sem=?, Marks=?, City=? " +
            "where id=?";

    public static String UPDATE_FIRSTNAME_QUERY = "update student_management " +
            "set FirstName=? " +
            "where id=?";

    public static String UPDATE_LASTNAME_QUERY = "update student_management " +
            "set LastName=? " +
            "where id=?";

    public static String UPDATE_SEM_QUERY = "update student_management " +
            "set Sem=? " +
            "where id=?";

    public static String UPDATE_MARKS_QUERY = "update student_management " +
            "set Marks=? " +
            "where id=?";

    public static String UPDATE_CITY_QUERY = "update student_management " +
            "set City=? " +
            "where id=?";
}
