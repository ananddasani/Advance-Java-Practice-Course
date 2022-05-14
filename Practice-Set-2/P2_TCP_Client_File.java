package Practical_Questions;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class P2_TCP_Client_File {

    public static void main(String[] args) throws IOException {

        //connection with server
        Socket socket = new Socket("localhost", 1111);

        //using streams
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        FileOutputStream outputStream = new FileOutputStream("Receive.txt");

        int read;
        while ((read = inputStream.read()) != -1) {
            outputStream.write((char) read);
        }

        System.out.println("File Received :)");
    }
}

/*
Received message form the server is :: Hello Client, You are connected successfully
 */