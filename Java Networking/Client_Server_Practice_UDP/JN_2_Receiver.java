/*
Client will send any string this server will respond it with all CAPITAL LETTERS
 */
package Client_Server_Practice_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JN_2_Receiver {

    public static void main(String[] args) throws IOException {

        //create the socket first
        DatagramSocket datagramSocket = new DatagramSocket(1234);

        //create the buffer to store the received data
        byte[] buffer = new byte[1024];

        //create packet to receive
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(datagramPacket);

        //extract the data
        String fromClient = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println("Received Data :: " + fromClient);
        System.out.println("Converted :: " + fromClient.toUpperCase());

        //--------------- sending result to client also ------------------------------
        String forClient = fromClient.toUpperCase();
        byte[] toSend = new byte[1024];
        toSend = forClient.getBytes();

        InetAddress sendIp = datagramPacket.getAddress();
        int port = datagramPacket.getPort();

        DatagramPacket datagramPacketToSent = new DatagramPacket(toSend, toSend.length, sendIp, port);
        datagramSocket.send(datagramPacketToSent);
        System.out.println("Sent Back to Client");

        datagramSocket.close();
    }
}
