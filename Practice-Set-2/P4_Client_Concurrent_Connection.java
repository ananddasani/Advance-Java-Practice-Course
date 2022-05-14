package Practical_Questions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class P4_Client_Concurrent_Connection {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 1234);

            while (true) {
                //take the string from the user
                System.out.print("\n\nEnter the String :: ");
                String str = scanner.nextLine();

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                //give it to the server
                outputStream.writeUTF(str);

                //take the reversed string form the server
                String fromServer = inputStream.readUTF();
                System.out.println(fromServer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
