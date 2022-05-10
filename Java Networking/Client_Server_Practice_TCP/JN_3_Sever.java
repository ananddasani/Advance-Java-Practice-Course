/*
Client sends 10 number and server respond with the number in sorted order
 */

package Client_Server_Practice_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class JN_3_Sever {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            //read 10 numbers from the client
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++)
                arr[i] = inputStream.readInt();

            System.out.println("Received Data");

            System.out.println("\nBefore Sorting");
            for (int n : arr)
                System.out.print(n + " ");

            //sort them
            Arrays.sort(arr);
            System.out.println("\nAfter Sorting");
            for (int n : arr)
                System.out.print(n + " ");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
