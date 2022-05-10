package URL_and_Inet_Package;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class JN3_url_connection {

    public static void main(String[] args) throws Exception {

        //Url object
        URL url = new URL("https://github.com/ananddasani");

        //open a connection
        URLConnection urlConnection = url.openConnection();

        //get Date
        long date = urlConnection.getDate();
        if (date == 0)
            System.out.println("No date information");
        else
            System.out.println("Date :: " + new Date(date));

        //get expiration date
        long exDate = urlConnection.getExpiration();
        if (exDate == 0)
            System.out.println("No Expiration Date Information available");
        else
            System.out.println("Expiration Date :: " + new Date(exDate));

        //get last modified date
        long lastModifiedDate = urlConnection.getLastModified();
        if (lastModifiedDate == 0)
            System.out.println("No Last modified date available");
        else
            System.out.println("Last Modified Date :: " + new Date(lastModifiedDate));

        //get content length
        long length = urlConnection.getContentLengthLong();
        if (length == -1)
            System.out.println("No Content Available");
        else
            System.out.println("Content Length :: " + length);

        //get connection-type
        System.out.println("Content Type :: " + urlConnection.getContentType());

        //show the content
        int c;
        if (length != 0) {
            System.out.println("\n=== Content ===");
            InputStream inputStream = urlConnection.getInputStream();

            while ((c = inputStream.read()) != -1)
                System.out.print((char) c);

            inputStream.close();
        }
        else
            System.out.println("No Content Available");
    }
}

/*
Date :: Tue Dec 21 21:57:54 IST 2021
No Expiration Date Information available
No Last modified date available
No Content Available
Content Type :: text/html; charset=utf-8

=== Content ===

<!DOCTYPE html>
<html lang="en" data-color-mode="auto" data-light-theme="light" data-dark-theme="dark">
  <head>
    <meta charset="utf-8">
  <link rel="dns-prefetch" href="https://github.githubassets.com">
  <link rel="dns-prefetch" href="https://avatars.githubusercontent.com">
  <link rel="dns-prefetch" href="https://github-cloud.s3.amazonaws.com">
  <link rel="dns-prefetch" href="https://user-images.githubusercontent.com/">
  <link rel="preconnect" href="https://github.githubassets.com" crossorigin>
  <link rel="preconnect" href="https://avatars.githubusercontent.com">
...
 */