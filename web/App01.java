package katrenich.web;

import org.apache.tools.ant.taskdefs.condition.Http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Demonstrate class URL
// And class HttpUrlConnection

public class App01{
    public static void main(String[] args) {
        try {
            URL url = new URL("http://google.com");
            System.out.println("Get host: " + url.getHost());
            System.out.println("Full form: " + url.toExternalForm());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            System.out.println("Method request: " + conn.getRequestMethod());
            System.out.println("Response message: " + conn.getResponseMessage());

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
