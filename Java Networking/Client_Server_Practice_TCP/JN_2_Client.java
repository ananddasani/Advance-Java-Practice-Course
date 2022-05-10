/*
Client sends 2 numbers and server respond with sum of them
 */

package Client_Server_Practice_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class JN_2_Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 1234);

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            //take string from the client
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter 1st Number :: ");
            int num1 = sc.nextInt();
            System.out.print("Enter 2nd Number :: ");
            int num2 = sc.nextInt();

            //give it to server
            outputStream.writeUTF(num1 + "");
            outputStream.writeUTF(num2 + "");

            //take the sum of server and show it on UI
            String sum = inputStream.readUTF();
            System.out.println("Sum is :: " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
SERVER

Received Data
Calculated & send back the result

CLIENT

Enter 1st Number :: 12
Enter 2nd Number :: 12
Sum is :: 24

 */