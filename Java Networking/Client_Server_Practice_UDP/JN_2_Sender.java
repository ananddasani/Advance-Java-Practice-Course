/*
Sends any string and gets CAPITAL LETTER
 */
package Client_Server_Practice_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JN_2_Sender {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress receiverIp = InetAddress.getByName("localhost");

        byte[] data = new byte[1024];
        String forServer = "Anand";
        data = forServer.getBytes();

        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, receiverIp, 1234);
        datagramSocket.send(datagramPacket);

        //------------------- Receive Result form the server ---------------------------
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacketToReceive = new DatagramPacket(buffer, buffer.length);

        datagramSocket.receive(datagramPacketToReceive);
        String formServer = new String(datagramPacketToReceive.getData(), 0, datagramPacket.getLength());

        System.out.println("Received from server :: " + formServer);

        datagramSocket.close();
    }
}

/*
RECEIVER

Received Data :: Anand
Converted :: ANAND
Sent Back to Client

SENDER

form server :: ANAND
 */