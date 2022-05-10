/*
Client send the message to server and server send message to client.
 */
package Client_Server_Practice_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JN_1_Receiver {

    public static void main(String[] args) throws IOException {

        //--------------------- Receive Data form client ----------------------

        //Create the DatagramSocket first
        DatagramSocket datagramSocket = new DatagramSocket(1234);

        //create the buffer for storing the received data
        byte[] buffer = new byte[1024];

        //create the datagramPacket by specifying buffer and it's size
        DatagramPacket datagramPacket2 = new DatagramPacket(buffer, buffer.length);

        //now receive the data
        datagramSocket.receive(datagramPacket2);

        //extract the data received
        String data = new String(datagramPacket2.getData(), 0, datagramPacket2.getLength());
        System.out.println(data);

        //----------------------- Send message to client ---------------------------

        String forClient = "hi from receiver :)";

        byte[] dataToSent = new byte[1024];
        dataToSent = forClient.getBytes();
        InetAddress ip = datagramPacket2.getAddress();
        int port = datagramPacket2.getPort();

        DatagramPacket datagramPacket3 = new DatagramPacket(dataToSent, dataToSent.length, ip, port);
        datagramSocket.send(datagramPacket3);

        datagramSocket.close();
    }
}
