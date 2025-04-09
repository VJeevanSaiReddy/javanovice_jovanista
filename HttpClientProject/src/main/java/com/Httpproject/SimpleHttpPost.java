package com.Httpproject;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
public class SimpleHttpPost {
    public static void main(String[] args) throws IOException {
        String text;
        StringBuffer sb = new StringBuffer();
        try{
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            String postData="{'email': 'test@reqres.in'"+", 'password': 'test'}";
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = postData.getBytes("UTF-8");
                os.write(input, 0, input.length);
            }
            System.out.println("Responsecode: "+con.getResponseCode());
            System.out.println("Response message"+con.getResponseMessage());
            try(BufferedReader br2 = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                while((text = br2.readLine()) != null) {
                    response.append(text.trim());
                }
                if(con.getHeaderField("Content-Type").equals("json")) {
                    JSONObject obj = new JSONObject(response.toString());
                    System.out.println(obj.toString(4));
                }
                else{
                    System.out.println(response.toString());
                }
            }
            con.disconnect();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
