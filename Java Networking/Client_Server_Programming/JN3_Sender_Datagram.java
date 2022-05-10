package Client_Server_Programming;

import java.io.IOException;
import java.net.*;

public class JN3_Sender_Datagram {

    public static void main(String[] args) {

        try {
            //create datagram socket object
            DatagramSocket datagramSocket = new DatagramSocket();

            //create inet add. object with receiver ip
            InetAddress ip = InetAddress.getByName("localhost");

            //for sending the data create DatagramPacket object and pass the data within constructor
            // also specify the size of data, address of receiver, port number
            byte[] data = new byte[1024];
            String str = "Hi, This is sender side";
            data = str.getBytes();

            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, ip, 1234);
            datagramSocket.send(datagramPacket); //call send method of DS and pass DP into it

            datagramSocket.close();

        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) { //datagramSocket.send(datagramPacket);
            e.printStackTrace();
        }
    }
}

/*
DatagramSocket( ) throws SocketException
DatagramSocket(int port) throws SocketException
DatagramSocket(int port, InetAddress ipAddress) throws SocketException
DatagramSocket(SocketAddress address) throws SocketException


The first creates a DatagramSocket bound to any unused port on the local
computer. The second creates a DatagramSocket bound to the port specified
by port. The third constructs a DatagramSocket bound to the specified port
and InetAddress. The fourth constructs a DatagramSocket bound to the
specified SocketAddress.

DatagramSocket defines many methods. Two of the most important are
send( ) and receive( ), which are shown here:
void send(DatagramPacket packet) throws IOException
void receive(DatagramPacket packet) throws IOException


DatagramPacket defines several constructors. Four are shown here:
DatagramPacket(byte data [ ], int size)
DatagramPacket(byte data [ ], int offset, int size)
DatagramPacket(byte data [ ], int size, InetAddress ipAddress, int port)
DatagramPacket(byte data [ ], int offset, int size, InetAddress ipAddress, int port)

The first constructor specifies a buffer that will receive data and the size of a
packet. It is used for receiving data over a DatagramSocket. The second form
allows you to specify an offset into the buffer at which data will be stored. The
third form specifies a target address and port, which are used by a
DatagramSocket to determine where the data in the packet will be sent. The
fourth form transmits packets beginning at the specified offset into the data.

Think of the first two forms as building an "in box," and the second two forms
as stuffing and addressing an envelope.

 */