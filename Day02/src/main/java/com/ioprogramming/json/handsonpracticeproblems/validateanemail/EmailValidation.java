package com.ioprogramming.json.handsonpracticeproblems.validateanemail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.regex.Pattern;

public class EmailValidation {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static void main(String[] args) {

        String jsonData = "{ \"email\": \"test@example.com\" }";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonData);

            if (rootNode.has("email")) {
                String email = rootNode.get("email").asText();

                if (pattern.matcher(email).matches()) {
                    System.out.println("Email is valid.");
                } else {
                    System.out.println("Invalid email format.");
                }
            } else {
                System.out.println("Email field is missing.");
            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }
    }
}
