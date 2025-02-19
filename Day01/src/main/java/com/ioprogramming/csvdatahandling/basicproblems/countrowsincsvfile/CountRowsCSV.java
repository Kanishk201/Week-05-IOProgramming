package com.ioprogramming.csvdatahandling.basicproblems.countrowsincsvfile;

import java.io.*;

public class CountRowsCSV {

        public static void main(String[] args){
                String filePath = "employee.csv";
                int rowCount = 0;
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    boolean isHeader = true;
                    while ((line = br.readLine()) != null) {
                        if (isHeader) {
                            isHeader = false;
                            continue;
                        }
                        rowCount++;
                    }
                } catch (IOException e) {
                    e.getStackTrace();
                }
            System.out.println("Number of Records: " + rowCount);
    }
}
