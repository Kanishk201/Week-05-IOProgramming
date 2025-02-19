package com.ioprogramming.csvdatahandling.intermediateproblems.searchrecordincsv;

import java.io.*;
import com.opencsv.CSVReader;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name for searching: ");
        String searchName = sc.nextLine();
      try(CSVReader reader = new CSVReader(new FileReader("employee.csv"))){
         String[] data;
         reader.readNext();
         while((data = reader.readNext()) != null){
            String name = data[1];

            if(name.equalsIgnoreCase(searchName)){
                System.out.println("ID: " + data[0] + "," + " Name: " + data[1] + "," + " Department: " + data[2] + "," + " Salary: " + data[3]);
            }
         }
      }
      catch (Exception e){
          e.printStackTrace();
      }
    }
}
