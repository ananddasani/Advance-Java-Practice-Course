/*
Get the data and time details from server on client request
 */

package Client_Server_Practice_TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class JN_4_Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 1234);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            //take the current date & time from the server
            String fromServer = inputStream.readUTF();
            System.out.println(fromServer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

