/*
Server will read the string (from client), finds number of character and digit and
send it back to client program
 */

package Client_Server_Practice_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JN_1_Server {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            //read the string given form the client
            String fromClient = inputStream.readUTF();
            System.out.println("Received Data");

            //calculate the number of character and digit in the string
            int digitCount = 0;
            int charCount = 0;

            //counting number of digits in the string
            for (int i = 0; i < fromClient.length(); i++) {
                if (fromClient.charAt(i) >= '0' && fromClient.charAt(i) <= '9')
                    digitCount++;
            }

            //counting number of char in the string
            charCount = fromClient.length() - digitCount;

            //send back the result to the client
            outputStream.writeUTF(digitCount + "");
            outputStream.writeUTF(charCount + "");
            System.out.println("Calculated & send back the result");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
