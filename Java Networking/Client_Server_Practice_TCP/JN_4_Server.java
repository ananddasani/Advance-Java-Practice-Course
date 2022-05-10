/*
Get the data and time details from server on client request
 */

package Client_Server_Practice_TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class JN_4_Server {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            //send the current date and time to the server
            Date date = new Date();
            String message = "Current date and time is :: " + date;

            //give it to the client
            outputStream.writeUTF(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
CLIENT

Current date and time is :: Thu Mar 24 10:58:17 IST 2022
 */