package org.example.client;

import com.google.gson.Gson;
import org.example.util.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ClientCalculator {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task: ");
        String example = scanner.next();
        //String example = "1/2";

        HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://localhost:8080/calculator?example=%s".formatted(example))).GET().build();

        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
        String result = send.body();


        Gson gson = new Gson();
        Response response = gson.fromJson(result, Response.class);
        System.out.println(response);

    }
}
