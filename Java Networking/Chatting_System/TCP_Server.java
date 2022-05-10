package Chatting_System;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCP_Server {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String fromClient, forClient;

        try {
            //open for connection
            ServerSocket serverSocket = new ServerSocket(1111);
            System.out.println("Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected\n");

            //using the streams
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            do {
                //read message form the client
                fromClient = inputStream.readUTF();
                System.out.println("\n" + fromClient);

                //write message for the client
                System.out.print("Type Here :: ");
                forClient = sc.nextLine();
                outputStream.writeUTF(forClient);
            } while (!fromClient.equals("CLOSE"));

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