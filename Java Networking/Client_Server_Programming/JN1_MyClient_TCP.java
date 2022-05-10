package Client_Server_Programming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class JN1_MyClient_TCP {

    public static void main(String[] args) {

        try {
            //make connection
            Socket socket = new Socket("127.0.0.1", 1111);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            //write message for the server (using output stream)
            dataOutputStream.writeUTF("Hello Server, Client Here");

            //(ACK) read message from server by input stream
            String message = dataInputStream.readUTF();
            System.out.println("message received from the server is :: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
