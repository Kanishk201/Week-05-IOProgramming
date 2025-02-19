package com.ioprogramming.csvdatahandling.intermediateproblems.modifycsvfile;

import java.io.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class ModifyCSV {
    public static void main(String[] args) {
        String filename = "employee.csv";
        String updatedfilename = "updatedemp.csv";

        try(CSVReader reader = new CSVReader(new FileReader(filename));
            CSVWriter writer = new CSVWriter(new FileWriter(updatedfilename))){
               String[] data;
               String[] header = reader.readNext();
               writer.writeNext(header);

               while((data = reader.readNext()) != null){
                   String department = data[2];
                   int salary = Integer.parseInt(data[3]);

                   if(department.equalsIgnoreCase("IT")){
                       salary += salary * 0.10;
                       data[3] = String.valueOf(salary);
                   }
                   writer.writeNext(data);
               }
            System.out.println("Salaries updated successfully in " + updatedfilename);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
