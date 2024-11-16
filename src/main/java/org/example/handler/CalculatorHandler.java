package org.example.handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.util.Calculator;
import org.example.util.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CalculatorHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();

        Map<String, String> parameters = getParameters(query);

        String example = parameters.get("example");
        System.out.println("example" + example);

        Response response = new Response();
        response.setResult(Calculator.calculation(example));

        Gson gson = new Gson();
        String json = gson.toJson(response);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, json.length());
        exchange.getResponseBody().write(json.getBytes());
        exchange.getResponseBody().close();
    }

    public Map<String, String> getParameters(String query) {
        Map<String, String> greetings = new HashMap<>();
        String[] split = query.split("&");
        for (String s : split) {
            String[] split1 = s.split("=");
            greetings.put(split1[0], split1[1]);
        }
        return greetings;
    }
}
