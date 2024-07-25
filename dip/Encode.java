package net.media.training.live.dip;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Base64;
import java.util.Hashtable;
import java.util.Map;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 19, 2011
 * Time: 4:47:27 PM
 * To change this template use File | Settings | File Templates.
 */


public class Encode {
    static String protocol = "http";
    static String host = "myfirstappwith.appspot.com";
    static String file = "index.html";
    private static Map<Integer, String> data = new Hashtable<Integer, String>();
    private static int count = 0;
    static String encodeStorefile = "beforeEncryption.txt";

    public String encodeLine(String line){
        return Base64.getEncoder().encodeToString(line.getBytes());
    }

    public String databaseRead() {
        StringBuilder output = new StringBuilder();
        for(Map.Entry<Integer, String> entry : data.entrySet()) {
            output.append(entry.getValue()).append("\n");
        }
        String inputString = output.toString();
        return encodeLine(inputString);
    }


    public InputStream getURLStream(){
        URL url = null;
        try {
            url = new URL(protocol, host, file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try{
            in = url.openStream();
        } catch (IOException e){
            e.printStackTrace();
        }
        return in;
    }



    public String urlRead() {
        InputStreamReader reader = new InputStreamReader(getURLStream());
        StringBuilder inputString1 = new StringBuilder();
        try {
            int c;
            c = reader.read();
            while (c != -1) {
                inputString1.append((char) c);
                c = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputString = inputString1.toString();
        String encodedString = encodeLine(inputString);
        return encodedString;
    }



    public String fileRead() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(encodeStorefile));
        String aLine;
        StringBuilder inputString1 = new StringBuilder();
        while ((aLine = reader.readLine()) != null){
            inputString1.append(aLine).append("\n");
        }
        String inputString = inputString1.toString();
        return encodeLine(inputString);
    }


    public int databaseWrite(String encodedString) {
        data.put(++count, encodedString);
        return count;
    }


    public void fileWrite(String encodedString) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(encodeStorefile));
        if(encodedString != null) writer.write(encodedString);
    }


    public void urlWrite(String encodedString) throws IOException {
        URL url = new URL(protocol, host, file);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            os.write(encodedString.getBytes());
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}