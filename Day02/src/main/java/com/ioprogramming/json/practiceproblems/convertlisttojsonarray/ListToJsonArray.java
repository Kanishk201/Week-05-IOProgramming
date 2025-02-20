package com.ioprogramming.json.practiceproblems.convertlisttojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonArray {
    public static void main(String[] args) {
        try{
            List<Person> people = Arrays.asList(
                    new Person("Alice", 34),
                    new Person("Bob", 43),
                    new Person("Charlie", 56)
            );

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(people);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
