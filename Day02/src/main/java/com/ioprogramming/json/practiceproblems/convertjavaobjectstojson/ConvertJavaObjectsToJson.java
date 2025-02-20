package com.ioprogramming.json.practiceproblems.convertjavaobjectstojson;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ConvertJavaObjectsToJson {

    public static void main(String[] args) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();

            Car car = new Car("Fortuner", "Toyota", "White");

            String jsonString = objectMapper.writeValueAsString(car);

            System.out.println(jsonString);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
