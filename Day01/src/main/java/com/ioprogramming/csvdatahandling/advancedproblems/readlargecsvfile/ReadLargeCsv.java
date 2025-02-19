package com.ioprogramming.csvdatahandling.advancedproblems.readlargecsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCsv {
    public static void main(String[] args) {
        String filePath = "large_file.csv";
        int chunkSize = 100;
        int totalCount = 0;
        int count = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                count++;
                totalCount++;

                if (count == chunkSize) {
                    System.out.println("Processed " + totalCount + " records");
                    count = 0; // Reset chunk counter
                }
            }

            if (count > 0) {
                System.out.println("Processed " + totalCount + " records");
            }
            System.out.println("Processing completed.");

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
