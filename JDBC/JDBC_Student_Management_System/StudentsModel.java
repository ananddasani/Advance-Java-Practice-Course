package JDBC_Student_Management_System;

public class StudentsModel {

    int Id;
    String FirstName;
    String LastName;
    int Sem;
    int Marks;
    String City;

    //Default Constructor
    public StudentsModel() {
    }

    //With ID
    public StudentsModel(int id, String firstName, String lastName, int sem, int marks, String city) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        Sem = sem;
        Marks = marks;
        City = city;
    }

    //Without ID
    public StudentsModel(String firstName, String lastName, int sem, int marks, String city) {
        FirstName = firstName;
        LastName = lastName;
        Sem = sem;
        Marks = marks;
        City = city;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getSem() {
        return Sem;
    }

    public void setSem(int sem) {
        Sem = sem;
    }

    public int getMarks() {
        return Marks;
    }

    public void setMarks(int marks) {
        Marks = marks;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    //Display Method
    @Override
    public String toString() {
        return "StudentsModel{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Sem=" + Sem +
                ", Marks=" + Marks +
                ", City='" + City + '\'' +
                '}';
    }
}
