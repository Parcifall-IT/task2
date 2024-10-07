package practice2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Task4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        var server = "https://httpbin.org/headers";
        try (HttpClient client = HttpClient.newHttpClient()) {
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(server))
                    .build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status code: " + response.statusCode());

            var jsonString = response.body();
            //System.out.println(jsonString);
            Map<String, Map<String, String>> deserializedData = new ObjectMapper().readValue(jsonString, new TypeReference<Map<String, Map<String, String>>>() {});
            var data = deserializedData.get("headers").entrySet();
            for (Map.Entry<String, String> d : data) {
                System.out.println(d.getKey() + ":" + d.getValue());
            }
        }
    }
}