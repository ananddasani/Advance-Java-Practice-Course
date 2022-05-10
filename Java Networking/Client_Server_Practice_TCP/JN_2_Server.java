/*
Client sends 2 numbers and server respond with sum of them
 */

package Client_Server_Practice_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JN_2_Server {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            //read 2 numbers from the client
            String num1 = inputStream.readUTF();
            String num2 = inputStream.readUTF();
            System.out.println("Received Data");

            //sum both the numbers
            int sum = Integer.parseInt(num1) + Integer.parseInt(num2);

            outputStream.writeUTF(sum + "");
            System.out.println("Calculated & send back the result");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
