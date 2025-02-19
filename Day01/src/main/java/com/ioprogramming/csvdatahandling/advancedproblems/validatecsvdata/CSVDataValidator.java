package com.ioprogramming.csvdatahandling.advancedproblems.validatecsvdata;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
public class CSVDataValidator {

    public static void main(String[] args) {
        String filePath = "employee1.csv";

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            System.out.println(String.join(",", records.get(0)));

            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);

                String email = row[1];
                String phone = row[2];

                boolean isValidEmail = emailPattern.matcher(email).matches();
                boolean isValidPhone = phonePattern.matcher(phone).matches();

                if (!isValidEmail || !isValidPhone) {
                    System.out.println("Invalid Row: " + String.join(",", row));
                    if (!isValidEmail) {
                        System.out.println("Error: Invalid Email - " + email);
                    }
                    if (!isValidPhone) {
                        System.out.println("Error: Invalid Phone Number - " + phone);
                    }
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
