package Client_Server_Programming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JN2_MyServer_TCP {

    public static void main(String[] args) {

        try {
            //open to connect
            ServerSocket serverSocket = new ServerSocket(1111);
            System.out.println("Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // get message form the client
            String message = dataInputStream.readUTF();
            System.out.println("\nMessage received from client is :: " + message);

            // write message for client
            dataOutputStream.writeUTF("Hello!! client you are now connected");

            serverSocket.close();

            System.out.println("\nClosing the connection...");
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
