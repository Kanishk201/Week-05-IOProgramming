package com.ioprogramming.json.practiceproblems.readandextractjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonReader {
    public static void main(String[] args) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Student student = objectMapper.readValue(new File("student.json"), Student.class);

            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
