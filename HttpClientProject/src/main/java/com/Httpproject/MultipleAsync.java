package com.Httpproject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.Map.Entry;

import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;


public class MultipleAsync {


    public static void main(String [] args) throws Exception {

        List<String> list = new ArrayList<>();

        list.add("https://reqres.in/api/users/5");
        list.add("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        list.add("https://swapi.dev/api/planets/3/");

        Map<String, CompletableFuture<HttpResponse<String>>> responses = new HashMap<>();

        HttpClient client = HttpClient.newHttpClient();

        for (String url: list) {

            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            CompletableFuture<HttpResponse<String>> future = null;
            future = client.sendAsync(req, HttpResponse.BodyHandlers.ofString());

            responses.put(url, future);
        }

        System.out.println("Requests sent out. Ready to do some more work...");
        Thread.sleep(5000);
        System.out.println("Ready to process responses...\n ");

        for(Entry<String, CompletableFuture<HttpResponse<String>>> entry:
                responses.entrySet()){

            String responseBody = entry.getValue().thenApply(HttpResponse::body).get();

            System.out.println("\n########## URL: " + entry.getKey());
            System.out.println("\nThe response body:");

            JSONObject jsonObject = new JSONObject(responseBody);
            System.out.println(jsonObject.toString(4));

        }
    }
}
