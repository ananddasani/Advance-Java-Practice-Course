package Client_Server_Practice_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JN_1_Sender {

    public static void main(String[] args) throws IOException {

        //----------------------- Send Data to server ----------------------------

        //first create datagram socket
        DatagramSocket datagramSocket = new DatagramSocket();

        InetAddress receiverIp = InetAddress.getByName("localhost");

        //prepare data
        byte[] data = new byte[1024];
        String forReceiver = "Hi, from sender :D";
        data = forReceiver.getBytes();

        //now create the packet and pack the data
        DatagramPacket datagramPacket1 = new DatagramPacket(data, data.length, receiverIp, 1234);

        //now send the packet
        datagramSocket.send(datagramPacket1);

        //--------------------- Receive message from server ------------------------------
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket4 = new DatagramPacket(buffer, buffer.length);

        datagramSocket.receive(datagramPacket4);

        String fromServer = new String(datagramPacket4.getData(), 0, datagramPacket4.getLength());
        System.out.println(fromServer);

        datagramSocket.close();

    }
}
