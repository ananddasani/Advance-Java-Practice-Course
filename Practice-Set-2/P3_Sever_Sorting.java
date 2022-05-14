/*
Client sends 10 number and server respond with the number in sorted order
 */

package Practical_Questions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class P3_Sever_Sorting {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");

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
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            //Output
//            for (int n : arr)
//                System.out.print(n + " ");

            //Send back to client
            for (int n : arr)
                outputStream.writeInt(n);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
