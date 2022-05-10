package Chatting_System;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCP_Client {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String fromServer, forServer;

        //connection with server
        Socket socket = new Socket("localhost", 1111);

        //using streams
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        do {
            //write message for the server
            System.out.print("\nType Here :: ");
            forServer = sc.nextLine();
            outputStream.writeUTF(forServer);

            //[ACK] reading message form the server
            fromServer = inputStream.readUTF();
            System.out.println("\n" + fromServer);

        } while (!fromServer.equals("CLOSE"));
    }
}

/*
Received message form the server is :: Hello Client, You are connected successfully
 */