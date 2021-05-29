package com.sda.weather;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EntryController {

    private EntryService entryService = new EntryService();
    private ObjectMapper objectMapper = new ObjectMapper();

    public String createNewEntry(String location) {
        try {
            Entry newEntry = entryService.createNewEntry(location);
            return objectMapper.writeValueAsString(newEntry);

        } catch (Exception e) {
          return "{\"error message\": \"" + e.getMessage() + "\"}";
        }
    }

}
