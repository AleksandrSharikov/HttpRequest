package org.example;


import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse;

public class Main {
    private static String URL = "http://94.198.50.185:7081/api/users";
    private static String answer;
    private static Gson gson = new Gson();
    private static HttpClient client = HttpClient.newHttpClient();
    private static String userStr;
    private static String sessionId;
    private static HttpResponse<String> response;

    private static User mrBrown = new User(3L,"James","Brown",(byte)18);
    private static User mrShelby = new User(3L,"Thomas","Shelby",(byte)18);


    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

     //   HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();

        response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        HttpHeaders headers = response.headers();
        System.out.println(headers);

        String jsBrown = gson.toJson(mrBrown);

      // HttpClient client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create(URL)).setHeader()
                .POST(HttpRequest.BodyPublishers.ofString(jsBrown))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }
}