/*
Program to Use Prepared Statement (For Dynamic Query)
 */
package JDBC_Basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_3_Dynamic_Query {

    public static String USER = "root";
    public static String PASS = "root";
    public static String URL = "jdbc:mysql://localhost:3306/anand";

    //Our Table Contains Fields :: Id, Name, Sem, City
    public static int ID = 0;
    public static String NAME = "";
    public static int SEM = 0;
    public static String CITY = "";

    //Dynamic Query
    public static String DYNAMIC_UPDATE_QUERY = "INSERT INTO students_jdbc " +
            "(Id, Name, Sem, City) " +
            "values(?, ?, ?, ?) ";

    public static void main(String[] args) {

        boolean isCollected = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            //Create Dynamic Statement
            PreparedStatement statement = connection.prepareStatement(DYNAMIC_UPDATE_QUERY);

            isCollected = takeDataFromUser();

            if (!isCollected) {
                System.out.println("Provide Data...");
                System.exit(1);
            }

            //verify
            System.out.println("\nID :: " + ID);
            System.out.println("Name :: " + NAME);
            System.out.println("Sem :: " + SEM);
            System.out.println("City :: " + CITY);

            //Now Complete the Statement by filling the ?
            statement.setInt(1, ID);
            statement.setString(2, NAME);
            statement.setInt(3, SEM);
            statement.setString(4, CITY);

            int result = statement.executeUpdate();

            System.out.println("\nInserted Successfully");
            System.out.println(result + " row affected");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to Collect Data from the user to inset it into the Table
     *
     * @return true if all the details which are required is given correctly
     */
    private static boolean takeDataFromUser() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID :: ");
        ID = sc.nextInt();

        //flush
        sc.nextLine();

        System.out.print("Enter Name :: ");
        NAME = sc.nextLine();

        System.out.print("Enter Sem :: ");
        SEM = sc.nextInt();

        //flush
        sc.nextLine();

        System.out.print("Enter City :: ");
        CITY = sc.nextLine();

        return true;
    }
}

/*
OUTPUT

Enter ID :: 6
Enter Name :: Ria
Enter Sem :: 7
Enter City :: PUne

ID :: 6
Name :: Ria
Sem :: 7
City :: PUne

Inserted Successfully
1 row affected
 */