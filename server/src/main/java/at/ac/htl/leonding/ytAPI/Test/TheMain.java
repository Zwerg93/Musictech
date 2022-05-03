package at.ac.htl.leonding.ytAPI.Test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;
import java.util.logging.Level;

public class TheMain {
    public static void main(String[] args) throws MalformedURLException {
        StringBuffer sbf1 = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        final HttpClient httpClient = new DefaultHttpClient();
        System.out.println("geben Sie bitte die ID des videos ein");
        String input = sc.nextLine();

        final HttpGet httpGet = new HttpGet("https://api.vevioz.com/api/button/mp3/"+input);
        HttpResponse response = null;
        System.out.println(httpGet + " test");
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException ex) {
            System.out.println("erreor " + ex);
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException ex) {
            System.out.println("error "+ex);
        }
        String line = "";
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException ex) {
                System.out.println("error " + ex);
            }

            sbf1.append(line);

        }
        System.out.println(sbf1.indexOf("NlLNXircsYg"));
        System.out.println();


    URL website = new URL(sbf1.substring(sbf1.indexOf("NlLNXircsYg")-35, sbf1.indexOf("NlLNXircsYg")+97));
    ReadableByteChannel rbc = null;
        try {
        rbc = Channels.newChannel(website.openStream());
    } catch (IOException e) {
        e.printStackTrace();
    }
    FileOutputStream fos = null;
        try {
        fos = new FileOutputStream("test.mp3");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        try {
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    } catch (IOException e) {
        e.printStackTrace();
    }

}




}
