/*
Get the string form the client and checks it is palindrome or not
 */
package Client_Server_Practice_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class JN_5_Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 1234);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            //take the string from the user
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the String :: ");
            String str = scanner.nextLine();

            //give it to the server
            outputStream.writeUTF(str);

            //take the message of palindrome or not form the server
            String fromServer = inputStream.readUTF();
            System.out.println(fromServer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
