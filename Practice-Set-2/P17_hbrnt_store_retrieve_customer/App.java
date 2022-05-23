package hbrnt_store_retrieve_customer;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("1. Enter Data\n2. Retrieve Data\n3. Exit");
            System.out.print("Enter your choice :: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    CustomerModel customer = takeDataAndPrepare();

                    //save in the table
                    session.persist(customer);
                    transaction.commit();

                    System.out.println("Data inserted successfully...");
                    break;
                case 2:
                    CustomerModel customerModel = retrieveCustomer(session);

                    //output the customer object returned
                    System.out.println("Customer Name :: " + customerModel.getName());
                    System.out.println("Customer Mobile :: " + customerModel.getMobile());
                    System.out.println("Customer Address :: " + customerModel.getAddress());

                    break;
                case 3:
                    System.out.println("Thanks for using this application");
                    System.exit(1);
                    break;
            }
        }

    }

    /**
     * This method will retrieve the object of customer model based on the id given
     * @param session will be used to get the object
     * @return his method will retrieve the object of customer model based on the id given
     */
    private static CustomerModel retrieveCustomer(Session session) {

        Scanner sc = new Scanner(System.in);

        //Take input from the user
        System.out.print("\nEnter Customer Id :: ");
        int cId = sc.nextInt();

        //using get method to get the customer based on id given
        CustomerModel customerModel = session.get(CustomerModel.class, cId);
        return customerModel;
    }

    /**
     * This method take info of the customer and return the CustomerModel object
     * which will be stored int the table
     *
     * @return customer model object with all the data given
     */
    private static CustomerModel takeDataAndPrepare() {

        Scanner sc = new Scanner(System.in);

        //Take input from the user
        System.out.print("\nEnter Customer Name :: ");
        String name = sc.next();

        System.out.print("\nEnter Customer Mobile :: ");
        String mobile = sc.next();

        System.out.print("Enter Customer Address :: ");
        String address = sc.next();

        //prepare the object (data)
        CustomerModel customer = new CustomerModel();

        customer.setName(name);
        customer.setMobile(mobile);
        customer.setAddress(address);

        return customer;
    }
}
