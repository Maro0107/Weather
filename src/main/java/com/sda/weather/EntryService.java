package com.sda.weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class EntryService {

    private EntryRepository entryRepository = new EntryRepository();
    private ObjectMapper objectMapper = new ObjectMapper();

    public EntryService() {
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Entry createNewEntry(String location) {

        if (location == null || location.isEmpty()) {
            throw new RuntimeException("Location can not be empty");
        }

        Entry entry = new Entry(location);

        try {
            // GET http://worldclockapi.com/api/json/utc/now
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://openweathermap.org/current"))
                    .build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String httpResponseBody = httpResponse.body();

        } catch (Exception e) {
            System.out.println("Log servera: " + e.getMessage());
        }

        return entryRepository.save(entry);
    }
}
