package Client_Server_Practice_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class JN_4_Sender {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();

        byte[] dataToSent = new byte[1024];
        String numbers = "";

        //take 10 number from the client
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 10 Number ending with #");
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter number " + (i + 1) + " :: ");
            numbers += scanner.next();
        }

        dataToSent = numbers.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");

        DatagramPacket datagramPacket = new DatagramPacket(dataToSent, dataToSent.length, ip, 1234);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
