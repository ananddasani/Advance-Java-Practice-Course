/*
Client will send a string to server to know the total number of character and digits in the string.
 */

package Client_Server_Practice_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class JN_1_Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 1234);

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            //take string from the client
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the String :: ");
            String str = sc.next();

            //give it to server
            outputStream.writeUTF(str);

            //accept result from client and show on UI
            String digitCount = inputStream.readUTF();
            String charCount = inputStream.readUTF();

            System.out.println("\nDigit Count :: " + digitCount);
            System.out.println("Character Count :: " + charCount);

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

Enter the String :: Anand2123
Digit Count :: 4
Character Count :: 5
 */