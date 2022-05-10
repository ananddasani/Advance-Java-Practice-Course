/*
Client sends 10 number and server respond with the number in sorted order
 */

package Client_Server_Practice_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class JN_3_Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 1234);

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            //take 10 numbers from the client
            Scanner sc = new Scanner(System.in);

            int[] arr = new int[10];

            System.out.println("You have to enter 10 numbers.");
            for (int i = 0; i < 10; i++) {
                System.out.print("Enter number " + (i + 1) + " :: ");
                arr[i] = sc.nextInt();
            }

            //give it to server
            for (int n : arr)
                outputStream.writeInt(n);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
SERVER

Received Data

Before Sorting
10 9 8 7 6 5 4 3 2 1
After Sorting
1 2 3 4 5 6 7 8 9 10

CLIENT

You have to enter 10 numbers.
Enter number 1 :: 10
Enter number 2 :: 9
Enter number 3 :: 8
Enter number 4 :: 7
Enter number 5 :: 6
Enter number 6 :: 5
Enter number 7 :: 4
Enter number 8 :: 3
Enter number 9 :: 2
Enter number 10 :: 1

 */