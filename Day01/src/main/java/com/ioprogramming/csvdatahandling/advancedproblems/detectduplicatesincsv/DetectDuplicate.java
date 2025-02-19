package com.ioprogramming.csvdatahandling.advancedproblems.detectduplicatesincsv;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class DetectDuplicate {
    public static void main(String[] args) {
        String filePath = "data.csv";
        int idColumnIndex = 0;

        Set<String> uniqueIds = new HashSet<>();
        List<String[]> duplicateRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext();
            System.out.println("Header: " + Arrays.toString(header));

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[idColumnIndex];

                if (uniqueIds.contains(id)) {
                    duplicateRecords.add(nextLine);
                } else {
                    uniqueIds.add(id);
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records found:");
                for (String[] record : duplicateRecords) {
                    System.out.println(Arrays.toString(record));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

