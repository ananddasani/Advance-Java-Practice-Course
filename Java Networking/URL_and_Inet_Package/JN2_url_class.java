package URL_and_Inet_Package;

import java.net.MalformedURLException;
import java.net.URL;

public class JN2_url_class {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.github.com/ananddasani");

            System.out.println("Protocol :: " + url.getProtocol());
            System.out.println("Port :: " + url.getPort() + " //Means Port is not explicitly set");
            System.out.println("Host :: " + url.getHost());
            System.out.println("Default Port :: " + url.getDefaultPort());
            System.out.println("File :: " + url.getFile());
            System.out.println("Ext :: " + url.toExternalForm());
            System.out.println("Authority :: " + url.getAuthority());

            System.out.println("Get Query :: " + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

/*
NOTE
The next two forms of the constructor allow you to break up the URL into its component parts:
URL(String protocolName, String hostName, int port, String path ) throws MalformedURLException
URL(String protocolName, String hostName, String path) throws MalformedURLException

Another frequently used constructor allows you to use an existing URL as a
reference context and then create a new URL from that context. Although this
sounds a little contorted, it’s really quite easy and useful.
URL(URL urlObj, String urlSpecifier) throws MalformedURLException


OUTPUT
Protocol :: https
Port :: -1 //Means Port is not explicitly set
Host :: www.github.com
Default Port :: 443
File :: /ananddasani
Ext :: https://www.github.com/ananddasani
Authority :: www.github.com
Get Query :: null
 */
