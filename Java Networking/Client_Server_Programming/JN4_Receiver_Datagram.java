package Client_Server_Programming;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class JN4_Receiver_Datagram {

    public static void main(String[] args) {

        try {
            //create a datagram socket object with specific port number
            DatagramSocket datagramSocket = new DatagramSocket(1234);

            //create a buffer to store a received data
            byte[] buffer = new byte[1024];

            //for receiving data create a datagramPacket object and buffer & size into constructor
            DatagramPacket datagramPacket = new DatagramPacket(buffer, 1024);

            //call receive method of DS and receive data into packet
            datagramSocket.receive(datagramPacket);

            //call getData method of DP to receive data
            String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(str);

            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
