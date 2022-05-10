package JDBC_Student_Management_System;

import java.util.Scanner;

public class MainActivity {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\tSTUDENT MANAGEMENT SYSTEM");

        while (true) {

            //Showing the menu
            System.out.println("\n1. Insert Student\n2. Update Student\n3. Delete Student\n4. Show Table\n5. Exit");
            System.out.print("\nEnter Your Choice :: ");
            int ch = sc.nextInt();

            //For Main Menu
            switch (ch) {
                case 1 -> {
                    //Take student data and set that data in student model
                    StudentsModel student = takeStudentData(); //set the details of students in model class


                    //Execute Query
                    int rowAffectedByInsertQuery = Query.executeInsertQuery(student);
                    if (rowAffectedByInsertQuery == 1)
                        System.out.println("\nStudent Inserted Successfully :)\n");
                    else
                        System.out.println("\nSomething went wrong :(\n");
                }
                case 2 -> {
                    //show the table before asking for id of student which is to be deleted
                    Query.executeSelectQuery();

                    //Ask for id to be Deleted
                    System.out.print("\nEnter ID You want to Update :: ");
                    int idToBeUpdated = sc.nextInt();

                    //Ask user first which details/detail of student they want to update
                    System.out.println("\n1. Update FirstName\n2. Update LastName\n3. Update Sem\n4. Update Marks\n5. Update City\n6. Update All");
                    System.out.print("\nEnter Your Choice :: ");
                    int updateChoice = sc.nextInt();

                    //For Updating Data
                    switch (updateChoice) {
                        case 1 -> {
                            //Update FirstName only
                            System.out.print("\nEnter new First Name :: ");
                            String newFirstName = sc.next();
                            int result1 = Query.executeUpdateSingleStringDataQuery(updateChoice, newFirstName, idToBeUpdated);
                            if (result1 == 1)
                                System.out.println("\nFirst Name Updated Successfully :)\n");
                            else
                                System.out.println("\nSomething Went Wrong :(\n");
                        }
                        case 2 -> {
                            //Update LastName only
                            System.out.print("\nEnter new Last Name :: ");
                            String newLastName = sc.next();
                            int result2 = Query.executeUpdateSingleStringDataQuery(updateChoice, newLastName, idToBeUpdated);
                            if (result2 == 1)
                                System.out.println("\nFirst Name Updated Successfully :)\n");
                            else
                                System.out.println("\nSomething Went Wrong :(\n");
                        }
                        case 3 -> {
                            //Update Sem only
                            System.out.print("\nEnter new Sem :: ");
                            int newSem = sc.nextInt();
                            int result3 = Query.executeUpdateSingleIntDataQuery(updateChoice, newSem, idToBeUpdated);
                            if (result3 == 1)
                                System.out.println("\nFirst Name Updated Successfully :)\n");
                            else
                                System.out.println("\nSomething Went Wrong :(\n");
                        }
                        case 4 -> {
                            //Update Marks only
                            System.out.print("\nEnter new Marks :: ");
                            int newMarks = sc.nextInt();
                            int result4 = Query.executeUpdateSingleIntDataQuery(updateChoice, newMarks, idToBeUpdated);
                            if (result4 == 1)
                                System.out.println("\nFirst Name Updated Successfully :)\n");
                            else
                                System.out.println("\nSomething Went Wrong :(\n");
                        }
                        case 5 -> {
                            //Update City only
                            System.out.print("\nEnter new City :: ");
                            String newCity = sc.next();
                            int result5 = Query.executeUpdateSingleStringDataQuery(updateChoice, newCity, idToBeUpdated);
                            if (result5 == 1)
                                System.out.println("\nFirst Name Updated Successfully :)\n");
                            else
                                System.out.println("\nSomething Went Wrong :(\n");
                        }
                        case 6 -> {
                            //Update All Data
                            //Take student data and set that data in student model
                            StudentsModel studentUpdatedData = takeStudentData(); //set the details of students in model class


                            //Execute Query
                            int rowAffectedByUpdateQuery = Query.executeUpdateAllDataQuery(studentUpdatedData, idToBeUpdated);
                            if (rowAffectedByUpdateQuery == 1)
                                System.out.println("\nStudent Details Updated Successfully :)\n");
                            else
                                System.out.println("\nSomething went wrong :(\n");
                        }
                        default -> {
                            System.out.println("\nWrong Option Selected\nexiting...");
                            System.exit(2);
                        }
                    }
                }
                case 3 -> {
                    //show the table before asking for id of student which is to be deleted
                    Query.executeSelectQuery();

                    //Ask for id to be Deleted
                    System.out.print("\nEnter ID You want to Delete :: ");
                    int idToBeDeleted = sc.nextInt();

                    //verify the query result
                    int rowAffectedByDeleteQuery = Query.executeDeleteQuery(idToBeDeleted);
                    if (rowAffectedByDeleteQuery == 1)
                        System.out.println("\nStudent Deleted Successfully :)\n");
                    else
                        System.out.println("\nSomething went wrong :(\n");
                }
                case 4 ->
                        //show the table
                        Query.executeSelectQuery();
                case 5 -> {
                    System.out.println("\nExiting...");
                    System.exit(1);
                }
                default -> {
                    System.out.println("\nWrong Option Selected\nexiting...");
                    System.exit(2);
                }
            }
        }

    }

    /**
     * Method to take the entire student data to insert into the table
     */
    private static StudentsModel takeStudentData() {

        String firstName, lastName, city;
        int sem, marks;

        System.out.print("Enter Student FirstName :: ");
        firstName = sc.next();
        sc.nextLine();

        System.out.print("Enter Student LastName :: ");
        lastName = sc.next();
        sc.nextLine();

        System.out.print("Enter Student Semester :: ");
        sem = sc.nextInt();

        System.out.print("Enter Student Marks :: ");
        marks = sc.nextInt();

        System.out.print("Enter Student City :: ");
        city = sc.next();

        return new StudentsModel(firstName, lastName, sem, marks, city);
    }
}

/*
OUTPUT


		STUDENT MANAGEMENT SYSTEM

1. Insert Student
2. Update Student
3. Delete Student
4. Show Table
5. Exit

Enter Your Choice :: 1
Enter Student FirstName :: Anand
Enter Student LastName :: Dasani
Enter Student Semester :: 6
Enter Student Marks :: 90
Enter Student City :: Porbandar

Student Inserted Successfully :)


1. Insert Student
2. Update Student
3. Delete Student
4. Show Table
5. Exit

Enter Your Choice :: 1
Enter Student FirstName :: Ria
Enter Student LastName :: Joshi
Enter Student Semester :: 8
Enter Student Marks :: 60
Enter Student City :: Goa

Student Inserted Successfully :)


1. Insert Student
2. Update Student
3. Delete Student
4. Show Table
5. Exit

Enter Your Choice :: 4


++++++++++++++++++++++++++++++++++++++++++
ID :: 6
FirstName :: Anand
LastName :: Dasani
Sem :: 6
Marks :: 90
City :: Porbandar
++++++++++++++++++++++++++++++++++++++++++
ID :: 7
FirstName :: Ria
LastName :: Joshi
Sem :: 8
Marks :: 60
City :: Goa
++++++++++++++++++++++++++++++++++++++++++

1. Insert Student
2. Update Student
3. Delete Student
4. Show Table
5. Exit

Enter Your Choice :: 2


++++++++++++++++++++++++++++++++++++++++++
ID :: 6
FirstName :: Anand
LastName :: Dasani
Sem :: 6
Marks :: 90
City :: Porbandar
++++++++++++++++++++++++++++++++++++++++++
ID :: 7
FirstName :: Ria
LastName :: Joshi
Sem :: 8
Marks :: 60
City :: Goa
++++++++++++++++++++++++++++++++++++++++++

Enter ID You want to Update :: 7

1. Update FirstName
2. Update LastName
3. Update Sem
4. Update Marks
5. Update City
6. Update All

Enter Your Choice :: 5

Enter new City :: Jaipur

First Name Updated Successfully :)


1. Insert Student
2. Update Student
3. Delete Student
4. Show Table
5. Exit

Enter Your Choice :: 4


++++++++++++++++++++++++++++++++++++++++++
ID :: 6
FirstName :: Anand
LastName :: Dasani
Sem :: 6
Marks :: 90
City :: Porbandar
++++++++++++++++++++++++++++++++++++++++++
ID :: 7
FirstName :: Ria
LastName :: Joshi
Sem :: 8
Marks :: 60
City :: Jaipur
++++++++++++++++++++++++++++++++++++++++++

1. Insert Student
2. Update Student
3. Delete Student
4. Show Table
5. Exit

Enter Your Choice :: 5

Exiting...

 */