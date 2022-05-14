/*
Implement Concurrent TCP Server programming in which more than one client can connect
and communicate with Server for sending the string and server returns the reverse of string to each of client.
 */

package Practical_Questions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class P4_Server_Concurrent_Connection {

    public static void main(String[] args) {

        int count = 0;

        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is waiting for Client...");

            while (true) {
                new CustomThread(serverSocket.accept(), count).start();
                System.out.println("New Client Connected :)\n");
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CustomThread extends Thread {

    Socket socket;
    int clientConnected;

    public CustomThread(Socket socket, int clientConnected) {
        this.socket = socket;
        this.clientConnected = clientConnected;
    }

    @Override
    public void run() {

        try {
            while (true) {
                System.out.println("Receiving Data from Client...");

                DataInputStream inputStream = new DataInputStream(socket.getInputStream()); //for Reading Data
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream()); //for Sending Data

                //get the string form the client
                String str = inputStream.readUTF();

                //Reverse the above string and send it back to client
                System.out.println("Reversing " + str + "...");

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                str = stringBuilder.reverse().toString(); // This is reverse of the actual string

                //send this reversed string to the client
                System.out.println("Sending the reversed string to the client...\n");
                outputStream.writeUTF(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
