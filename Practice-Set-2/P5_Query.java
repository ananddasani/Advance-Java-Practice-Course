package Practical_Questions;

import java.sql.*;

public class P5_Query {

    /**
     * Method to Show the Entire Table Content
     */
    public static void executeSelectQuery() {

        Connection connection = P5_MyConnector.makeConnection();

        try {
            //Create Statement
            Statement statement = connection.createStatement();

            //collect the result
            ResultSet resultSet = statement.executeQuery(P5_Constants.SELECT_QUERY);

            //Show the result
            while (resultSet.next()) {
                System.out.println("++++++++++++++++++++++++++++++++++++++++++");

                System.out.println("ID :: " + resultSet.getString("Id"));
                System.out.println("FirstName :: " + resultSet.getString("FirstName"));
                System.out.println("LastName :: " + resultSet.getString("LastName"));
                System.out.println("Sem :: " + resultSet.getString("Sem"));
                System.out.println("Marks :: " + resultSet.getString("Marks"));
                System.out.println("City :: " + resultSet.getString("City"));
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method will Insert the New Entry of Students in the DB Table
     *
     * @param student is the details of the student which is to be inserted in the table
     * @return the row count affected (if returning 0, it means query is not successfully executed) some error occurred :(
     */
    public static int executeInsertQuery(P5_StudentsModel student) {

        //JDBC Main Code
        Connection connection = P5_MyConnector.makeConnection();
        int rowAffected = 0;

        try {

            //Create Statement
            PreparedStatement preparedStatement = connection.prepareStatement(P5_Constants.INSERT_QUERY);

            //Now complete the dynamic query
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getSem());
            preparedStatement.setInt(4, student.getMarks());
            preparedStatement.setString(5, student.getCity());

            //Now execute the query
            rowAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowAffected;
    }

    /**
     * Method will Delete the Entry of Students in the DB Table whose id is passed by P5_MainActivity
     *
     * @param idToBeDeleted is the student which is to be deleted from the DB
     * @return 1 is student deleted successfully or else return 0 --> means query is not executed successfully
     */
    public static int executeDeleteQuery(int idToBeDeleted) {
        Connection connection = P5_MyConnector.makeConnection();
        int rowAffected = 0;

        //Create Statement
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(P5_Constants.DELETE_QUERY);

            //Now complete the dynamic query
            preparedStatement.setInt(1, idToBeDeleted);

            //Now execute the query
            rowAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAffected;
    }


    /**
     * Method to Update String Single Data of Student (FirstName, LastName, City)
     *
     * @param updateChoice stats which data of student is to be updated
     * @param newData      this is the data to be replaced
     * @return 1 if successful else 0
     */
    public static int executeUpdateSingleStringDataQuery(int updateChoice, String newData, int idToBeUpdated) {

        Connection connection = P5_MyConnector.makeConnection();
        int rowAffected = 0;

        try {
            switch (updateChoice) {
                case 1:
                    //Update FirstName only
                    PreparedStatement preparedStatement = connection.prepareStatement(P5_Constants.UPDATE_FIRSTNAME_QUERY);
                    preparedStatement.setString(1, newData);
                    preparedStatement.setInt(2, idToBeUpdated);
                    rowAffected = preparedStatement.executeUpdate();
                    break;

                case 2:
                    //Update LastName only
                    PreparedStatement preparedStatement2 = connection.prepareStatement(P5_Constants.UPDATE_LASTNAME_QUERY);
                    preparedStatement2.setString(1, newData);
                    preparedStatement2.setInt(2, idToBeUpdated);
                    rowAffected = preparedStatement2.executeUpdate();
                    break;

                case 5:
                    //Update City only
                    PreparedStatement preparedStatement5 = connection.prepareStatement(P5_Constants.UPDATE_CITY_QUERY);
                    preparedStatement5.setString(1, newData);
                    preparedStatement5.setInt(2, idToBeUpdated);
                    rowAffected = preparedStatement5.executeUpdate();
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowAffected;
    }

    /**
     * Method to Update String Int Data of Student (Sem, Marks)
     *
     * @param updateChoice stats which data of student is to be updated
     * @param newData      this is the data to be replaced
     * @return 1 if successful else 0
     */
    public static int executeUpdateSingleIntDataQuery(int updateChoice, int newData, int idToBeUpdated) {

        Connection connection = P5_MyConnector.makeConnection();
        int rowAffected = 0;

        try {
            switch (updateChoice) {
                case 3:
                    //Update Sem only
                    PreparedStatement preparedStatement3 = connection.prepareStatement(P5_Constants.UPDATE_SEM_QUERY);
                    preparedStatement3.setInt(1, newData);
                    preparedStatement3.setInt(2, idToBeUpdated);
                    rowAffected = preparedStatement3.executeUpdate();
                    break;

                case 4:
                    //Update Marks only
                    PreparedStatement preparedStatement4 = connection.prepareStatement(P5_Constants.UPDATE_MARKS_QUERY);
                    preparedStatement4.setInt(1, newData);
                    preparedStatement4.setInt(2, idToBeUpdated);
                    rowAffected = preparedStatement4.executeUpdate();
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowAffected;
    }

    public static int executeUpdateAllDataQuery(P5_StudentsModel student, int idToBeUpdated) {
        Connection connection = P5_MyConnector.makeConnection();
        int rowAffected = 0;

        try {

            //Create Statement
            PreparedStatement preparedStatement = connection.prepareStatement(P5_Constants.UPDATE_ALL_QUERY);

            //Now complete the dynamic query
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getSem());
            preparedStatement.setInt(4, student.getMarks());
            preparedStatement.setString(5, student.getCity());
            preparedStatement.setInt(6, idToBeUpdated);

            //Now execute the query
            rowAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowAffected;
    }
}

/*
executeUpdate Returns: either
(1) the row count for SQL Data Manipulation Language (DML) statements or
(2) 0 for SQL statements that return nothing
 */