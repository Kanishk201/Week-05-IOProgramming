package com.ioprogramming.csvdatahandling.intermediateproblems.sortcsvrecords;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class SortCSVRecords {
    public static void main(String[] args) {
        String filePath = "employee.csv";
        ArrayList<String[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] employee;

            while ((employee = reader.readNext()) != null) {
                records.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] header = records.remove(0);

        // Sort records by salary in descending order
        Collections.sort(records, (emp1, emp2) -> Integer.parseInt(emp2[3]) - Integer.parseInt(emp1[3]));

        System.out.println(String.join(", ", header));

        for (int i = 0; i < 5 && i < records.size(); i++) {
            System.out.println(String.join(", ", records.get(i)));
        }

    }
}
