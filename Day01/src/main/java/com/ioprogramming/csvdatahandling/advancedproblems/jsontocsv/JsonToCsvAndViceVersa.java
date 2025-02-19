package com.ioprogramming.csvdatahandling.advancedproblems.jsontocsv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class JsonToCsvAndViceVersa {
    private static final String JSON_FILE = "students.json";
    private static final String CSV_FILE = "students.csv";

    public static void main(String[] args) {
        jsonToCsv(JSON_FILE, CSV_FILE);
        csvToJson(CSV_FILE, "students_converted.json");
    }

    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class);
            List<Student> students = objectMapper.readValue(new File(jsonFile), listType);

            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {

                writer.writeNext(new String[]{"ID", "Name", "Age", "Grade"});

                for (Student student : students) {
                    writer.writeNext(new String[]{
                            String.valueOf(student.id),
                            student.name,
                            String.valueOf(student.age),
                            student.grade
                    });
                }
            }

            System.out.println("JSON successfully converted to CSV: " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<Student> students = new ArrayList<>();
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                students.add(new Student(
                        Integer.parseInt(nextLine[0]),
                        nextLine[1],
                        Integer.parseInt(nextLine[2]),
                        nextLine[3]
                ));
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile), students);

            System.out.println("CSV successfully converted to JSON: " + jsonFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
