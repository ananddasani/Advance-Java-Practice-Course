/*
Client will send array of 10 number and server will send the sum of that numbers
 */
package Client_Server_Practice_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class JN_4_Receiver {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(1234);

        byte[] buffer = new byte[1024];

        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        datagramSocket.receive(datagramPacket);

        String dataReceived = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

        int sum = 0;

        //tokenize the string with #
        String[] numbers = dataReceived.split("#");

        System.out.println("These are the number got.");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");

            //keep summing also
            sum += Integer.parseInt(numbers[i]);
        }

        System.out.println("\n\nSum :: " + sum);
    }
}

/*
CLIENT

Enter 10 Number ending with #
Enter number 1 :: 1#
Enter number 2 :: 2#
Enter number 3 :: 3#
Enter number 4 :: 4#
Enter number 5 :: 5#
Enter number 6 :: 6#
Enter number 7 :: 7#
Enter number 8 :: 8#
Enter number 9 :: 9#
Enter number 10 :: 10#

SERVER

These are the number got.
1 2 3 4 5 6 7 8 9 10

Sum :: 55
 */