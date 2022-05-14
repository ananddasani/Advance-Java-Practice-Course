//Implement TCP Server for transferring files using Socket and ServerSocket.

package Practical_Questions;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P2_TCP_Server_File {

    public static void main(String[] args) {

        try {
            //open for connection
            ServerSocket serverSocket = new ServerSocket(1111);
            System.out.println("Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected\n");

            //using the FILE streams
            FileInputStream inputStream = new FileInputStream("Anand.txt");
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            int read;
            while ((read = inputStream.read()) != -1){
                outputStream.write(read);
            }

            System.out.println("File Transferred :)");

            System.out.println("\nClosing the connection...");
            serverSocket.close();
            System.out.println("Connection is closed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
Waiting for client...
Client connected

Message received form the client is :: Hello Server, Client Here !!!

Closing the connection...
Connection is closed
 */