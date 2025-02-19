package com.ioprogramming.csvdatahandling.basicproblems.readandprintcsvfile;

import java.io.*;

public class ReadCSVFile {
    public static void main(String[] args) {
        String filepath = "students.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                for(String value : columns) {
                    System.out.print(value+"\t");
                }
                System.out.println();
            }
        }
        catch(IOException e){
           e.getStackTrace();
        }
    }
}
