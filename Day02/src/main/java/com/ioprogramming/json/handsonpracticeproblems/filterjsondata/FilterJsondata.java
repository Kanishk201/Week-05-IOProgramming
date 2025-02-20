package com.ioprogramming.json.handsonpracticeproblems.filterjsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class FilterJsondata {
    public static void main(String[] args) {
        String json = "[{\"name\": \"Alice\", \"age\": 25}, " +
                "{\"name\": \"Bob\", \"age\": 30}, " +
                "{\"name\": \"Charlie\", \"age\": 28}, " +
                "{\"name\": \"David\", \"age\": 22}]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            List<JsonNode> filteredRecords = new ArrayList<>();

            for (JsonNode node : rootNode) {
                if (node.get("age").asInt() > 25) {
                    filteredRecords.add(node);
                }
            }

            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredRecords);
            System.out.println(filteredJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

