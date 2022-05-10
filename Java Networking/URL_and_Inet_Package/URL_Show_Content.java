package URL_and_Inet_Package;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URL_Show_Content {

    public static void main(String[] args) {

        try {
            //create URL Object
            URL url = new URL("https://github.com/ananddasani/Java_Collection_Framework");

            //open a connection
            URLConnection connection = url.openConnection();

            int ch;
            StringBuilder content = new StringBuilder();

            if (connection.getContentLength() != 0) {

                //show the data using inputStreams
                InputStream inputStream = connection.getInputStream();
                System.out.println("Fetching Content...");
                while ((ch = inputStream.read()) != -1)
                    content.append((char) ch);

                System.out.print(content);
            } else
                System.out.println("No Content to show.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
