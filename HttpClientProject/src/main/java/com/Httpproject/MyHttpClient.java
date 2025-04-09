package com.Httpproject;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

    public static void main(String [] args) throws Exception{

        String url = "https://reqres.in/api/users";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + resp.statusCode());

        System.out.println("Body:" );
        JSONObject jsonObj = new JSONObject(resp.body());
        System.out.println("JSON:\n" + jsonObj.toString(4));

    }
}