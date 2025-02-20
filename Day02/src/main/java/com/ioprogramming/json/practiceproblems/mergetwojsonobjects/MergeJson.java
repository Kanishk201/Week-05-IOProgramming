package com.ioprogramming.json.practiceproblems.mergetwojsonobjects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String json1 = "{ \"name\": \"Alice\", \"age\": 25 }";
        String json2 = "{ \"city\": \"New York\" }";

        JsonNode node1 = objectMapper.readTree(json1);
        JsonNode node2 = objectMapper.readTree(json2);

        ((ObjectNode) node1).setAll((ObjectNode) node2);

        String mergedJson = objectMapper.writeValueAsString(node1);
        System.out.println(mergedJson);
    }
}
