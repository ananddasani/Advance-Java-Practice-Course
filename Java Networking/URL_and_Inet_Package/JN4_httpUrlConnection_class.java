package URL_and_Inet_Package;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JN4_httpUrlConnection_class {

    public static void main(String[] args) throws Exception {

        //create a URL object
        URL url = new URL("http://www.google.com");

        //open a connection
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        //Display Request Method
        System.out.println("Request Method :: " + httpURLConnection.getRequestMethod());

        //Display Respond Code
        System.out.println("Response Code :: " + httpURLConnection.getResponseCode());

        //Display Response Message
        System.out.println("Response Message " + httpURLConnection.getResponseMessage());

        //get a list of header file and set of header key
        Map<String, List<String>> map = httpURLConnection.getHeaderFields();
        Set<String> hdrField = map.keySet();

        System.out.println("\nHere is the Header...\n");
        for (String key : hdrField)
            System.out.println("Key :: " + key + " Values :: " + map.get(key));
    }
}

/*
OUTPUT

Request Method :: GET
Response Code :: 200
Response Message OK

Here is the Header...

Key :: Transfer-Encoding Values :: [chunked]
Key :: null Values :: [HTTP/1.1 200 OK]
Key :: Server Values :: [gws]
Key :: P3P Values :: [CP="This is not a P3P policy! See g.co/p3phelp for more info."]
Key :: Date Values :: [Tue, 21 Dec 2021 16:43:24 GMT]
Key :: Accept-Ranges Values :: [none]
Key :: X-Frame-Options Values :: [SAMEORIGIN]
Key :: Cache-Control Values :: [private, max-age=0]
Key :: Vary Values :: [Accept-Encoding]
Key :: Set-Cookie Values :: [NID=511=aYIY3311hTgueP2vQOHzZiRU6GuhuslJ1icuLWQ5c66PcVxFvcJdDzNDBwBqqgHctEgrc7vxhA5DHoYeaS9w98Pp9SFkHtYuBpV2Vtt8eGPS0iO1BC7G3bXxbMrH8k82i0PErnU9_wkTgv4d21kv6M6XwW5wEIgXypvgecfezLs; expires=Wed, 22-Jun-2022 16:43:24 GMT; path=/; domain=.google.com; HttpOnly, 1P_JAR=2021-12-21-16; expires=Thu, 20-Jan-2022 16:43:24 GMT; path=/; domain=.google.com; Secure]
Key :: Expires Values :: [-1]
Key :: X-XSS-Protection Values :: [0]
Key :: Content-Type Values :: [text/html; charset=ISO-8859-1]
 */