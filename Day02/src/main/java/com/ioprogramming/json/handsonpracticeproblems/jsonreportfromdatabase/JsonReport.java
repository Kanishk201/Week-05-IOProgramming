package com.ioprogramming.json.handsonpracticeproblems.jsonreportfromdatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;

public class JsonReport {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, age, city FROM users")) {

            ObjectMapper mapper = new ObjectMapper();
            ArrayNode jsonArray = mapper.createArrayNode();

            while (rs.next()) {
                ObjectNode row = mapper.createObjectNode();
                row.put("id", rs.getInt("id"));
                row.put("name", rs.getString("name"));
                row.put("age", rs.getInt("age"));
                row.put("city", rs.getString("city"));
                jsonArray.add(row);
            }

            String jsonReport = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);

            File file = new File("report.json");
            mapper.writeValue(file, jsonArray);

            System.out.println("JSON Report Generated: ");
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

