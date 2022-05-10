package URL_and_Inet_Package;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class JN1_inet_address {

    public static void main(String[] args) {

        try {
            //Using factory method of InetAddress class
            InetAddress ip = InetAddress.getByName("www.google.com");

            //display Name of the website
            System.out.println("Name :: " + ip.getHostName());

            //display IP address of the website
            System.out.println("IP Address :: " + ip.getHostAddress());

            //get local host add. (My Laptop Address)
            System.out.println("\nLocal Host :: " + InetAddress.getLocalHost());

        } catch (UnknownHostException e) {
            System.err.println("Unknown Host or IP ");
        }
    }
}

/*
OUTPUT
Name :: www.google.com
IP Address :: 142.250.182.196

Local Host :: Anand/192.168.1.152
 */
