package com.Httpproject;

import java.io.*;
import java.net.*;
import org.json.JSONObject;
public class SimpleHttpConnectionApi {
    public static void main(String[] args) throws IOException {
        BufferedReader br=null;
        String line;
        StringBuffer sb=new StringBuffer();
       try{
           URL url=new URL("https://reqres.in/api/users");
           HttpURLConnection con=(HttpURLConnection)url.openConnection();
           con.setRequestMethod("GET");
           int status=con.getResponseCode();
           if(status>=200 && status<=299){
              br=new BufferedReader(new InputStreamReader(con.getInputStream()));
              while((line=br.readLine())!=null){
                  sb.append(line);
              }
              String responseText=sb.toString();
              if(con.getHeaderField("Content-Type").contains("json")){
                    JSONObject obj=new JSONObject(responseText);
                    try(FileWriter fw=new FileWriter("com.Httpproject.SimpleHttpConnectionApi.json")){
                        fw.write(obj.toString(4));
                    }
                    System.out.println(obj.toString(4));
              }
              else{
                  System.out.println(responseText);
              }
           }
           else{
               System.out.println("request failed");
           }
           System.out.println("Headers"+con.getHeaderFields());
           System.out.println("length"+con.getHeaderField("content-length"));
           con.disconnect();
       }
       catch(IOException e){
           e.printStackTrace();
       }
       finally{
            br.close();
            System.out.println("Connection closed");
       }

    }
}
