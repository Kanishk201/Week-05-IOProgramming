package com.ioprogramming.csvdatahandling.intermediateproblems.filterrecordsfromcsv;

import java.io.*;
import com.opencsv.CSVReader;
public class FilterRecords {
    public static void main(String[] args) {
        try(CSVReader reader = new CSVReader(new FileReader("students.csv"))){
            String[] nextLine;
            reader.readNext();
            while((nextLine = reader.readNext()) != null){
                String name = nextLine[1];
                int marks = Integer.parseInt(nextLine[3]);

                if(marks > 80){
                    System.out.print("Name: " + name + "," + " Marks: " + marks + "\n");
                }
            }
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
}
