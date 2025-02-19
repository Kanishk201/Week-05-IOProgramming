package com.ioprogramming.csvdatahandling.advancedproblems.convertcsvtojava;

import com.opencsv.CSVReader;
import java.io.*;
import java.util.*;

public class CsvToJava {
    public static void main(String[] args) {
        String filePath = "students1.csv";
        List<Student> students = readCsv(filePath);

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readCsv(String filePath) {
        List<Student> students = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                String name = line[0];
                int age = Integer.parseInt(line[1]);
                String grade = line[2];
                students.add(new Student(name, age, grade));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
}

