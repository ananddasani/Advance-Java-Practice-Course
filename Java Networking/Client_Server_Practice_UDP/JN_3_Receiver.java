/*
Client will send the string and server has to reverse it
 */
package Client_Server_Practice_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JN_3_Receiver {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(1234);

        byte[] buffer = new byte[1024];

        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        datagramSocket.receive(datagramPacket);

        String fromClient = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println("Get Data :: " + fromClient);

        String rev = "";
        for (int i = fromClient.length() - 1; i >= 0; i--)
            rev += fromClient.charAt(i);

        System.out.println("Reverse :: " + rev);

        //--------------------------- Send this result to client also ----------------
        byte[] dataToSent = new byte[1024];
        dataToSent = rev.getBytes();

        InetAddress ip = datagramPacket.getAddress();
        int port = datagramPacket.getPort();

        DatagramPacket datagramPacketToSent = new DatagramPacket(dataToSent, dataToSent.length, ip, port);
        datagramSocket.send(datagramPacketToSent);

        datagramSocket.close();
    }
}
