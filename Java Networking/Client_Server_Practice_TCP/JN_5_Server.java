/*
Get the string form the client and checks it is palindrome or not
 */

package Client_Server_Practice_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JN_5_Server {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            //get the string form the client
            String str = inputStream.readUTF();
            boolean isPalindrome = checkPalindrome(str);

            String message = str + " is ";
            if (isPalindrome)
                message += "palindrome";
            else
                message += "not palindrome";

            //give it to the client
            outputStream.writeUTF(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkPalindrome(String str) {

        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--)
            rev += str.charAt(i);

        return str.equals(rev);
    }
}
/*
CLIENT

Enter the String :: nitin
nitin is palindrome

 */