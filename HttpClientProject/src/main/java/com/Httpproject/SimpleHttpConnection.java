package com.Httpproject;
import java.net.*;
import java.io.*;
public class SimpleHttpConnection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        String text;
        StringBuffer sb = new StringBuffer();
        try{
            URL url=new URL("https://en.wikipedia.org/wiki/Sachin_Tendulkar");
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int status=conn.getResponseCode();
            System.out.println("The status is: "+status);
            System.out.println("Response message: \n");
            if(status>=200 && status<=299){
                br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while((text=br.readLine())!=null){
                    sb.append(text);
                }
                br.close();
                System.out.println(sb.toString());
            }
            else{
                System.out.println("request failed");
            }
            System.out.println("Headers"+conn.getHeaderFields());
            conn.disconnect();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
