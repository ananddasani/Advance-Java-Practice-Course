package Client_Server_Practice_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JN_3_Sender {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();

        String forServer = "Anand";
        byte[] data = new byte[1024];
        data = forServer.getBytes();

        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 1234);
        datagramSocket.send(datagramPacket);

        //---------------- Get result from server -----------------------------
        byte[] buffer = new byte[1024];

        DatagramPacket datagramPacketToReceive = new DatagramPacket(buffer, buffer.length);

        datagramSocket.receive(datagramPacketToReceive);

        String fromServer = new String(datagramPacketToReceive.getData(), 0, datagramPacketToReceive.getLength());
        System.out.println("Received Result :: " + fromServer);

        datagramSocket.close();
    }
}

/*
RECEIVER

Get Data :: Anand
Reverse :: dnanA

SENDER

Received Result :: dnanA
 */