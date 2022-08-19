package se.jensensthlm.hellogithubactions;

import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ControllerBase {
    private HttpClient http = HttpClient.newHttpClient();

    public ResponseEntity<String> get(String uri) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        try {
            var httpResponse = http.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );
            return ResponseEntity
                    .status(httpResponse.statusCode())
                    .body(httpResponse.body());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
